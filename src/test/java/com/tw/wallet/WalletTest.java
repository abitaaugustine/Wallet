package com.tw.wallet;

import com.tw.wallet.exceptions.AmountInWalletExceededException;
import com.tw.wallet.exceptions.InvalidAmountException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    @Test
    void shouldPutMoneyIntoWalletIfAmountIsValid() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        Money money1 = new Money(10, CurrencyType.RUPEES);
        Money money2 = new Money(10, CurrencyType.DOLLARS);

        assertDoesNotThrow(() -> wallet.put(money1));
        assertDoesNotThrow(() -> wallet.put(money2));
    }

    @Test
    void shouldNotPutMoneyIntoWalletIfAmountIsInValid() {
        Wallet wallet = new Wallet();

        assertThrows(InvalidAmountException.class, () -> wallet.put(new Money(-10, CurrencyType.RUPEES)));
        assertThrows(InvalidAmountException.class, () -> wallet.put(new Money(-10, CurrencyType.DOLLARS)));
    }

    @Test
    void shouldTakeMoneyFromWalletIfThereIsAmount() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        wallet.put(new Money(10, CurrencyType.RUPEES));

        assertDoesNotThrow(() -> wallet.take(new Money(5, CurrencyType.RUPEES)));
    }

    @Test
    void shouldNotTakeMoneyFromWalletIfTheAmountInWalletIsLessThanDesired() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        wallet.put(new Money(1, CurrencyType.RUPEES));
        wallet.put(new Money(1, CurrencyType.DOLLARS));

        assertThrows(AmountInWalletExceededException.class, () -> wallet.take(new Money(200, CurrencyType.RUPEES)));
    }

    @Test
    void shouldReturnTotalAmountInRupees() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        wallet.put(new Money(50, CurrencyType.RUPEES));
        wallet.put(new Money(1, CurrencyType.DOLLARS));

        double totalAmount = wallet.total(CurrencyType.RUPEES);

        assertEquals(124.85, totalAmount);
    }

    @Test
    void shouldReturnTotalAmountInDollars() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        wallet.put(new Money(74.85, CurrencyType.RUPEES));
        wallet.put(new Money(1, CurrencyType.DOLLARS));
        wallet.put(new Money(149.7, CurrencyType.RUPEES));

        double totalAmount = wallet.total(CurrencyType.DOLLARS);

        assertEquals(4, totalAmount);
    }
}