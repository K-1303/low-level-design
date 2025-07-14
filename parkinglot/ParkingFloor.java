package parkinglot;

import java.util.List;
import java.util.Optional;
import parkinglot.parkingspot.ParkingSpot;
import parkinglot.vehicle.Vehicle;


public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }

    public synchronized Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle) {
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.canFitVehicle(vehicle))
                .findFirst();
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}