package parkinglot.fee;

import java.util.Map;
import parkinglot.ParkingTicket;
import parkinglot.vehicle.VehicleType;

public class VehicleBasedFeeStrategy implements FeeStrategy {
    private final Map<VehicleType, Double> hourlyRates = Map.of(
        VehicleType.CAR, 20.0,
        VehicleType.BIKE, 10.0,
        VehicleType.TRUCK, 30.0
    );

    @Override
    public double calculateFee(ParkingTicket ticket) {
        long duration = ticket.getExitTimeStamp() - ticket.getEntryTimeStamp();
        long hours = (duration / (1000 * 60 * 60)) + 1; // Round up to the next hour
        return hours * hourlyRates.get(ticket.getVehicle().getType());
    }
}