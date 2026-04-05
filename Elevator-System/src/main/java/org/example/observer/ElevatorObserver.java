package org.example.observer;

import org.example.entity.Elevator;
import org.example.enums.ElevatorState;

public interface ElevatorObserver {
    // Called when an elevator's state changes
    void onElevatorStateChange(Elevator elevator, ElevatorState state);


    // Called when an elevator changes its current floor
    void onElevatorFloorChange(Elevator elevator, int floor);
}
