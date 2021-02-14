package com.tw.wallet;

import com.tw.wallet.exceptions.AmountInWalletExceededException;

public class Wallet {
    private final Money amountInWallet;

    public Wallet() {
        amountInWallet = new Money();
    }

    public void put(Money money) {
        amountInWallet.add(money);
    }

    public void take(Money takeAmount) throws AmountInWalletExceededException {
        if (amountInWallet.amount < takeAmount.amount * takeAmount.currencyType.multiplier) {
            throw new AmountInWalletExceededException("Wallet does not have enough balance");
        }
        amountInWallet.take(takeAmount);
    }

    public double total(CurrencyType currencyType) {
        return amountInWallet.amount / currencyType.multiplier;
    }
}
