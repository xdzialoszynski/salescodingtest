package com.awe.salescoding.tools;

public class Sums {
    private double totalTaxes = 0.0;
    private double totalPrices = 0.0;

    public double getTotalTaxes() {
        return totalTaxes;
    }


    public double getTotalPrices() {
        return totalPrices;
    }


    public void add(double taxe, double price) {
        totalTaxes += taxe;
        totalPrices += price;
    }
}
