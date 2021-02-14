package com.tw.wallet;

import com.tw.wallet.exceptions.InvalidAmountException;

import java.util.Objects;

public class Money {
    public double amount;
    public CurrencyType currencyType;

    public Money(double amount, CurrencyType currencyType) throws InvalidAmountException {
        if (amount <= 0)
            throw new InvalidAmountException("Invalid money amount");
        this.amount = amount;
        this.currencyType = currencyType;
    }

    public Money() {
        amount = 0;
        currencyType = CurrencyType.RUPEES;
    }

    public void add(Money addAmount) {
        this.amount += addAmount.amount * addAmount.currencyType.multiplier;
    }

    public void take(Money takeAmount) {
        amount -= takeAmount.amount * takeAmount.currencyType.multiplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return money.amount * money.currencyType.multiplier == amount * currencyType.multiplier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount * currencyType.multiplier);
    }
}
