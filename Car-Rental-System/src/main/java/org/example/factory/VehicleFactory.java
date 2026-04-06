package org.example.factory;

import org.example.enums.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type,
                                        String registrationNumber, String model, double baseRentalPrice) {
        switch (type) {
            case ECONOMY:
                return new EconomyVehicle(
                        registrationNumber, model, type, baseRentalPrice);
            case LUXURY:
                return new LuxuryVehicle(
                        registrationNumber, model, type, baseRentalPrice);
            case SUV:
                return new SUVVehicle(
                        registrationNumber, model, type, baseRentalPrice);
            case BIKE:
                return new BikeVehicle(
                        registrationNumber, model, type, baseRentalPrice);
            case AUTO:
                return new AutoVehicle(
                        registrationNumber, model, type, baseRentalPrice);
            default:
                throw new IllegalArgumentException(
                        "Unsupported vehicle type: " + type);
        }
    }
}
