import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private final List<Currency> amountInWallet = new ArrayList<>();

    public boolean put(Currency amount) {
        amountInWallet.add(amount);
        return true;
    }

    public boolean take(Currency takeAmount) {
        for (Currency currency : amountInWallet) {
            if (currency.amount >= takeAmount.amount && currency.currencyType == takeAmount.currencyType) {
                amountInWallet.remove(takeAmount);
                if (currency.amount - takeAmount.amount > 0) {
                    amountInWallet.add(new Currency(currency.amount - takeAmount.amount, takeAmount.currencyType));
                }
                return true;
            }
        }
        return false;
    }
}
