import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WalletTest {
    @Test
    void putMoneyIntoTheWallet() {
        Wallet wallet = new Wallet();

        assertTrue(wallet.add(10));
    }
}
