package com.awe.salescoding.tools;

import com.awe.salescoding.data.CommandDetail;
import com.awe.salescoding.data.Goods;

public class TaxeCaclulatorImpl implements TaxeCaclulator {

    public static final double IMPORTATION_TAXE_RATE = 5.0 / 100;
    public static final double BASIC_SALE_RATE = 10.0 / 100;

    private double taxeValue = 0.0;
    private double priceWithTaxe = 0.0;
    private final CommandDetail detail;

    public TaxeCaclulatorImpl(CommandDetail detail) {
        this.detail = detail;
    }

    @Override
    public void compute() {
        double unitaryTaxeValue = Rounder.roundUpToNearest005(getBasicTaxeFor(detail) + getImportTaxeFor(detail));
        priceWithTaxe = (detail.price() + unitaryTaxeValue) * detail.quantity();
        taxeValue = unitaryTaxeValue * detail.quantity();
    }

    @Override
    public double getTaxeValue() {
        return Rounder.round2Digits(taxeValue);
    }

    @Override
    public double getPriceWithTaxe() {
        return Rounder.round2Digits(priceWithTaxe);
    }

    private double getImportTaxeFor(CommandDetail detail) {
        if (detail.imported()) {
            return detail.price() * IMPORTATION_TAXE_RATE;
        }
        return 0.0;
    }

    private double getBasicTaxeFor(CommandDetail detail) {
        Goods good = Goods.fromName(detail.name());
        if (good.isCategoryNotOther()) {
            return 0.0;
        }
        return detail.price() * BASIC_SALE_RATE;
    }
}
