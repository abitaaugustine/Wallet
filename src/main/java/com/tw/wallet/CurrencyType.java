package com.tw.wallet;

public enum CurrencyType {
    Rupees(1),
    Dollars(74.85);

    public final double multiplier;

    CurrencyType(double multiplier) {
        this.multiplier = multiplier;
    }
}
