package parkinglot.fee;

import parkinglot.ParkingTicket;

public class FlatRateBasedStrategy implements FeeStrategy {
    private static final double RATE_PER_HOUR = 10.0; // Flat rate for parking

    @Override
    public double calculateFee(ParkingTicket ticket) {
        long duration = ticket.getExitTimeStamp() - ticket.getEntryTimeStamp();
        long hours = (duration / (1000 * 60 * 60)) + 1; // Round up to the next hour
        return RATE_PER_HOUR * hours; // Apply flat rate for each hour parked
    }
}