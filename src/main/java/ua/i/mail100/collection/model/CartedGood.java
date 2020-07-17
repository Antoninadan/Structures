package ua.i.mail100.collection.model;

public abstract class CartedGood implements Purchased {
    private Purchased purchased;
    private int amount;

    public CartedGood(Purchased purchased, int amount) {
        this.purchased = purchased;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public abstract String toString();

    public void changeAmount(int newAmount) {
        if (newAmount <= 0) {
            throw new RuntimeException("not validate amount");
        }
        amount = newAmount;
    }
}
