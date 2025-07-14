package parkinglot.parkingspot;

import parkinglot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private final String spotId;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
        this.isOccupied = false;
    }

    public synchronized boolean isAvailable() {
        return !isOccupied;
    }

    public synchronized boolean assignVehicle(Vehicle vehicle) {
        if (isOccupied) {
            return false; // Spot is already occupied
        }

        this.vehicle = vehicle;
        this.isOccupied = true;
        return true; // Vehicle assigned successfully
    }

    public synchronized void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false; // Mark the spot as available
    }

    public String getSpotId() {
        return spotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public abstract boolean canFitVehicle(Vehicle vehicle);
}