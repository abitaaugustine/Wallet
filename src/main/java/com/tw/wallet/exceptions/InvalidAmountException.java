package com.tw.wallet.exceptions;

public class InvalidAmountException extends Exception {
    public InvalidAmountException(String invalid_amount) {
        super(invalid_amount);
    }
}
