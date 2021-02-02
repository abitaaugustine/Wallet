package com.tw.wallet;

public class Currency {
    public final double amount;
    public final CurrencyType currencyType;

    public Currency(double amount, CurrencyType currencyType) {
        this.amount = amount;
        this.currencyType = currencyType;
    }
}
