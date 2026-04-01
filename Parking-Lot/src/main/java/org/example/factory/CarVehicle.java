package org.example.factory;

import org.example.strategy.parkingfee.ParkingFeeStrategy;

public class CarVehicle extends Vehicle {
    public CarVehicle(String licensePlate, String vehicleType, ParkingFeeStrategy feeStrategy) {
        super(licensePlate, vehicleType, feeStrategy);
    }
}