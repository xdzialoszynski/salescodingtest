package com.awe.salescoding.tools;

public class Rounder {

    public static double roundUpToNearest005(double number) {
        double ceiledValue = Math.ceil(number / 0.05) * 0.05;
        return ceiledValue;
    }

    public static double round2Digits(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
