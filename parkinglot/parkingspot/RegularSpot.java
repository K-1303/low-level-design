package parkinglot.parkingspot;

import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

public class RegularSpot extends ParkingSpot {
    public RegularSpot(String spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        // Regular spots can fit cars and bikes
        return vehicle.getType() == VehicleType.CAR || vehicle.getType() == VehicleType.BIKE;
    }
}

