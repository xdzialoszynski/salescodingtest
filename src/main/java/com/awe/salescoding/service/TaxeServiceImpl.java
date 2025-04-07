package com.awe.salescoding.service;

import com.awe.salescoding.data.CommandDetail;
import com.awe.salescoding.data.Input;
import com.awe.salescoding.data.Output;
import com.awe.salescoding.tools.Sums;
import com.awe.salescoding.tools.TaxeCaclulator;
import com.awe.salescoding.tools.TaxeCaclulatorImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxeServiceImpl implements TaxeService {

    @Override
    public Output computeOutput(Input input) {
        List<CommandDetail> details = input.details();
        if (details == null) {
            return null;
        }

        Sums sums = new Sums();
        List<CommandDetail> commandDetails = details
                .stream()
                .map(detail -> {
                    TaxeCaclulator taxeCaclulator = new TaxeCaclulatorImpl(detail);
                    taxeCaclulator.compute();
                    sums.add(taxeCaclulator.getTaxeValue(), taxeCaclulator.getPriceWithTaxe());
                    return new CommandDetail(detail.imported(), detail.quantity(), detail.name(), taxeCaclulator.getPriceWithTaxe());
                })
                .collect(Collectors.toList());

        return new Output(commandDetails, sums.getTotalTaxes(), sums.getTotalPrices());
    }
}
