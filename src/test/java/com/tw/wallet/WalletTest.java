package com.tw.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    @Test
    void shouldPutMoneyIntoTheWallet(){
        Wallet wallet = new Wallet();
        Currency currency1= new Currency(10, CurrencyType.Rupees);
        Currency currency2 = new Currency(10, CurrencyType.Dollars);

        assertDoesNotThrow(()-> wallet.put(currency1));
        assertDoesNotThrow(()-> wallet.put(currency2));
    }

    @Test
    void shouldTakeMoneyFromWalletIfThereIsAmount() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        wallet.put(new Currency(10, CurrencyType.Rupees));

        assertTrue(wallet.take(new Currency(5, CurrencyType.Rupees)));
    }

    @Test
    void shouldNotTakeMoneyFromWalletIfTheAmountInWalletIsLessThanDesired() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        wallet.put(new Currency(1, CurrencyType.Rupees));
        wallet.put(new Currency(5, CurrencyType.Dollars));

        assertFalse(wallet.take(new Currency(5, CurrencyType.Rupees)));
    }

    @Test
    void shouldReturnTotalAmountInRupees() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        wallet.put(new Currency(50, CurrencyType.Rupees));
        wallet.put(new Currency(1, CurrencyType.Dollars));

        double totalAmount = wallet.total(CurrencyType.Rupees);

        assertEquals(124.85, totalAmount);
    }

    @Test
    void shouldReturnTotalAmountInDollars() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        wallet.put(new Currency(74.85, CurrencyType.Rupees));
        wallet.put(new Currency(1, CurrencyType.Dollars));
        wallet.put(new Currency(149.7, CurrencyType.Rupees));

        double totalAmount = wallet.total(CurrencyType.Dollars);

        assertEquals(4, totalAmount);
    }
}