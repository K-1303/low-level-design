package org.example.factory;

import org.example.strategy.parkingfee.ParkingFeeStrategy;

public class BikeVehicle extends Vehicle {
    public BikeVehicle(String licensePlate, String vehicleType, ParkingFeeStrategy feeStrategy) {
        super(licensePlate, vehicleType, feeStrategy);
    }
}
