package com.tw.wallet;

public class InvalidAmountException extends Exception {
    public InvalidAmountException(String invalid_amount) {
        super(invalid_amount);
    }
}
