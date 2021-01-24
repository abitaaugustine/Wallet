import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WalletTest {
    @Test
    void putMoneyIntoTheWallet() {
        Wallet wallet = new Wallet();

        assertTrue(wallet.add(10));
    }

    @Test
    void takeMoneyFromWalletIfThereIsAmount() {
        Wallet wallet = new Wallet();
        wallet.add(10);

        assertTrue(wallet.take(5));
    }

    @Test
    void shouldNotTakeMoneyFromWalletIfTheAmountInWalletisLessThanDesired() {
        Wallet wallet = new Wallet();
        wallet.add(1);

        assertFalse(wallet.take(5));
    }

}
