package tax;

import static tax.FuelType.*;

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
    private final static TaxBracket[] alternativeBrackets = {
            new TaxBracket(256, 2060),
            new TaxBracket(226, 1750),
            new TaxBracket(191, 1230),
            new TaxBracket(171, 820),
            new TaxBracket(151, 505),
            new TaxBracket(131, 195),
            new TaxBracket(111, 155),
            new TaxBracket(101, 135),
            new TaxBracket(91, 115),
            new TaxBracket(76, 95),
            new TaxBracket(51, 15),
            new TaxBracket(1, 0),
            new TaxBracket(0, 0),
    };

    public ImprovedTaxCalculator(int year) {
        super(year);
    }

    @Override
    public int calculateTax(Vehicle vehicle) {
        int taxAmount = 0;
        int emissions = vehicle.getCo2Emissions();
        TaxBracket[] taxBrackets;

        switch (vehicle.getFuelType()) {
            case DIESEL:
                taxBrackets = dieselBrackets;
                break;
            case ALTERNATIVE_FUEL:
                taxBrackets = alternativeBrackets;
                break;
            case PETROL:
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

        if (getYear() != vehicle.getDateOfFirstRegistration().getYear()) {
            if (vehicle.getListPrice() > 20000){
                switch (vehicle.getFuelType()) {
                    case PETROL:
                    case DIESEL:
                        taxAmount = 450;
                        break;
                    case ALTERNATIVE_FUEL:
                        taxAmount = 440;
                        break;
                    case ELECTRIC:
                        taxAmount = 310;
                        break;
                    default:
                        taxAmount = 0;
                        break;
                }
            }
            else{
                switch (vehicle.getFuelType()) {
                    case PETROL:
                    case DIESEL:
                        taxAmount = 140;
                        break;
                    case ALTERNATIVE_FUEL:
                        taxAmount = 130;
                        break;
                    case ELECTRIC:
                    default:
                        taxAmount = 0;
                        break;
                }
            }

        }
        return taxAmount;
    }
}
