package tax;

public class ImprovedTaxCalculator extends TaxCalculator {
    private final static TaxBracket[] dieselBrackets = new TaxBracket[]{
            new TaxBracket(256, 2070),
            new TaxBracket(226, 2070),
            new TaxBracket(191, 1760),
            new TaxBracket(171, 1240),
            new TaxBracket(151, 830),
            new TaxBracket(131, 515),
            new TaxBracket(111, 205),
            new TaxBracket(101, 165),
            new TaxBracket(91, 145),
            new TaxBracket(76, 125),
            new TaxBracket(51, 105),
            new TaxBracket(1, 25)
    };
    private final static TaxBracket[] petrolBrackets = new TaxBracket[]{
            new TaxBracket(256, 2070),
            new TaxBracket(226, 1760),
            new TaxBracket(191, 1240),
            new TaxBracket(171, 830),
            new TaxBracket(151, 515),
            new TaxBracket(131, 205),
            new TaxBracket(111, 165),
            new TaxBracket(101, 145),
            new TaxBracket(91, 125),
            new TaxBracket(76, 105),
            new TaxBracket(51, 25),
            new TaxBracket(1, 10)
    };

    public ImprovedTaxCalculator(int year) {
        super(year);
    }

    @Override
    int calculateTax(Vehicle vehicle) {
        int taxAmount = 0;
        int emissions = vehicle.getCo2Emissions();
        TaxBracket[] taxBrackets;

        switch (vehicle.getFuelType()) {
            case DIESEL:
                taxBrackets = dieselBrackets;
                break;
            // PETROL
            default:
                taxBrackets = petrolBrackets;
                break;
        }

        for (TaxBracket bracket : taxBrackets) {
            if (emissions >= bracket.getLowerBound()) {
                taxAmount = bracket.getAmount();
                break;
            }
        }
        return taxAmount;
    }
}
