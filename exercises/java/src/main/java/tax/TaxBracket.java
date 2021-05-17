package tax;

public class TaxBracket {
    private int lowerBound;
    private int amount;

    public TaxBracket(int lowerBound, int amount) {
        this.lowerBound = lowerBound;
        this.amount = amount;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getAmount() {
        return amount;
    }
}
