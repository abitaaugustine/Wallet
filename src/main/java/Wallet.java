public class Wallet {
    private int amount = 0;

    public boolean add(int amount) {
        this.amount += amount;
        return true;
    }
}
