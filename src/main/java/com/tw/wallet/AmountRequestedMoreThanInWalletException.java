package com.tw.wallet;

public class AmountRequestedMoreThanInWalletException extends Exception {
    public AmountRequestedMoreThanInWalletException(String s) {
        super(s);
    }
}
