package com.tw.wallet;

public enum CurrencyType {
    RUPEES(1),
    DOLLARS(74.85);

    public final double multiplier;

    CurrencyType(double multiplier) {
        this.multiplier = multiplier;
    }
}
