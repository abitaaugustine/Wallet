import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    @Test
    void shouldPutMoneyIntoTheWallet() {
        Wallet wallet = new Wallet();

        assertTrue(wallet.put(new Currency(10, CurrencyType.Rupees)));
        assertTrue(wallet.put(new Currency(10, CurrencyType.Dollars)));
    }

    @Test
    void shouldTakeMoneyFromWalletIfThereIsAmount() {
        Wallet wallet = new Wallet();
        wallet.put(new Currency(10, CurrencyType.Rupees));

        assertTrue(wallet.take(new Currency(5, CurrencyType.Rupees)));
    }

    @Test
    void shouldNotTakeMoneyFromWalletIfTheAmountInWalletIsLessThanDesired() {
        Wallet wallet = new Wallet();
        wallet.put(new Currency(1, CurrencyType.Rupees));
        wallet.put(new Currency(5, CurrencyType.Dollars));

        assertFalse(wallet.take(new Currency(5, CurrencyType.Rupees)));
    }
}
