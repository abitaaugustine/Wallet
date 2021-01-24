public class Wallet {
    private int amount = 0;

    public boolean add(int amount) {
        this.amount += amount;
        return true;
    }

    public boolean take(int amount) {
        if(this.amount<amount)
            return false;
        this.amount-=amount;
        return true;
    }

}
