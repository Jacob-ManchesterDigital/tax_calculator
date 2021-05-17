package tax;

public class ImprovedTaxCalculator extends TaxCalculator {

    public ImprovedTaxCalculator(int year) {
        super(year);
    }

    @Override
    int calculateTax(Vehicle vehicle) {
        int taxAmount = 0;
        int emissions = vehicle.getCo2Emissions();

        int[][] taxBoundaries = new int[][]{
                {256, 2070},
                {226, 1760},
                {191, 1240},
                {171, 830},
                {151, 515},
                {131, 205},
                {111, 165},
                {101, 145},
                {91, 125},
                {76, 105},
                {51, 25},
                {1, 10}
        };

        for (int[] boundary : taxBoundaries) {
            if (emissions >= boundary[0]) {
                taxAmount = boundary[1];
                break;
            }
        }

        return taxAmount;
    }
}
