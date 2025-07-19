package parkinglot.parkingspot;

public class ParkingSpotFactory {
    public static ParkingSpot createParkingSpot(ParkingSpotType type, String spotId) {
        switch (type) {
            case COMPACT -> {
                return new CompactSpot(spotId);
            }
            case LARGE -> {
                return new LargeSpot(spotId);
            }
            case REGULAR -> {
                return new RegularSpot(spotId);
            }
            default -> throw new IllegalArgumentException("Unknown parking spot type: " + type);
        }
    }
}