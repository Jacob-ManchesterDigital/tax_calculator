package tax;

import java.time.LocalDate;

public class Vehicle {
    private final int co2Emissions;
    private final FuelType fuelType;
    private final LocalDate dateOfFirstRegistration;
    private final int listPrice;

    Vehicle(int co2Emissions, FuelType fuelType, LocalDate dateOfFirstRegistration, int listPrice) {
        this.co2Emissions = co2Emissions;
        this.fuelType = fuelType;
        this.dateOfFirstRegistration = dateOfFirstRegistration;
        this.listPrice = listPrice;
    }

    int getCo2Emissions() {
        return co2Emissions;
    }

    FuelType getFuelType() {
        return fuelType;
    }

    LocalDate getDateOfFirstRegistration() {
        return dateOfFirstRegistration;
    }

    int getListPrice() {
        return listPrice;
    }
}
