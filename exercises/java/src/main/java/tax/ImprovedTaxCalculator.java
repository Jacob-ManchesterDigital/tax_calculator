package tax;

public class ImprovedTaxCalculator extends TaxCalculator {

    public ImprovedTaxCalculator(int year) {
        super(year);
    }

    @Override
    int calculateTax(Vehicle vehicle) {
        int taxAmount = 0;
        int emissions = vehicle.getCo2Emissions();

        if (emissions > 255){
            taxAmount = 2070;
        }
        else if (emissions >= 226){
            taxAmount = 1760;
        }
        else if (emissions >= 191){
            taxAmount = 1240;
        }
        else if (emissions >= 171){
            taxAmount = 830;
        }
        else if (emissions >= 151){
            taxAmount = 515;
        }
        else if (emissions >= 131){
            taxAmount = 205;
        }
        else if (emissions >= 111){
            taxAmount = 165;
        }
        else if (emissions >= 101){
            taxAmount = 145;
        }
        else if (emissions >= 91){
            taxAmount = 125;
        }
        else if (emissions >= 76){
            taxAmount = 105;
        }
        else if (emissions >= 51){
            taxAmount = 25;
        }
        else if (emissions >= 1){
            taxAmount = 10;
        }

        return taxAmount;
    }
}
