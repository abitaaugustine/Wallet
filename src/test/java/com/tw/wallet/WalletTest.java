package com.tw.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    @Test
    void shouldPutMoneyIntoTheWallet(){
        Wallet wallet = new Wallet();
        Currency currency1= new Currency(10, CurrencyType.RUPEES);
        Currency currency2 = new Currency(10, CurrencyType.DOLLARS);

        assertDoesNotThrow(()-> wallet.put(currency1));
        assertDoesNotThrow(()-> wallet.put(currency2));
    }

    @Test
    void shouldTakeMoneyFromWalletIfThereIsAmount() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        wallet.put(new Currency(10, CurrencyType.RUPEES));

        assertDoesNotThrow(()->wallet.take(new Currency(5, CurrencyType.RUPEES)));
    }

    @Test
    void shouldNotTakeMoneyFromWalletIfTheAmountInWalletIsLessThanDesired() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        wallet.put(new Currency(1, CurrencyType.RUPEES));
        wallet.put(new Currency(5, CurrencyType.DOLLARS));

        assertThrows(AmountRequestedMoreThanInWalletException.class,()->wallet.take(new Currency(5, CurrencyType.RUPEES)));
    }

    @Test
    void shouldReturnTotalAmountInRupees() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        wallet.put(new Currency(50, CurrencyType.RUPEES));
        wallet.put(new Currency(1, CurrencyType.DOLLARS));

        double totalAmount = wallet.total(CurrencyType.RUPEES);

        assertEquals(124.85, totalAmount);
    }

    @Test
    void shouldReturnTotalAmountInDollars() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        wallet.put(new Currency(74.85, CurrencyType.RUPEES));
        wallet.put(new Currency(1, CurrencyType.DOLLARS));
        wallet.put(new Currency(149.7, CurrencyType.RUPEES));

        double totalAmount = wallet.total(CurrencyType.DOLLARS);

        assertEquals(4, totalAmount);
    }
}