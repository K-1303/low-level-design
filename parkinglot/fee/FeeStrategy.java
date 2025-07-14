package parkinglot.fee;

import parkinglot.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket ticket);
}