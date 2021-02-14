package com.tw.wallet.exceptions;

public class AmountInWalletExceededException extends Exception {
    public AmountInWalletExceededException(String s) {
        super(s);
    }
}
