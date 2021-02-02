package com.tw.wallet;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private final List<Currency> amountInWallet = new ArrayList<>();

    public void put(Currency currency) throws InvalidAmountException {
        if(currency.amount<=0)
            throw new InvalidAmountException("invalid amount");
        amountInWallet.add(currency);
    }



    public boolean take(Currency takeAmount) {
        for (Currency currency : amountInWallet) {
            if (currency.amount >= takeAmount.amount && currency.currencyType == takeAmount.currencyType) {
                amountInWallet.remove(currency);
                if (currency.amount - takeAmount.amount > 0) {
                    amountInWallet.add(new Currency(currency.amount - takeAmount.amount, takeAmount.currencyType));
                }
                return true;
            }
        }
        return false;
    }

    public double total(CurrencyType currencyType) {
        double totalAmount = 0;

        for (Currency currency : amountInWallet) {
            totalAmount += currency.amount * currency.currencyType.multiplier;
        }
        return totalAmount / currencyType.multiplier;
    }
}
