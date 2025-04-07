package com.awe.salescoding.data;

import java.util.List;

public record Output(List<CommandDetail> details, double salesTaxes, double total) {
    public Output {
        details = List.copyOf(details);
        salesTaxes = Math.round(salesTaxes * 100.0) / 100.0;
        total = Math.round(total * 100.0) / 100.0;
    }
}
