package org.example.strategy;

import org.example.entity.Elevator;

public interface SchedulingStrategy {
    // Determines the next stop for the given elevator
    int getNextStop(Elevator elevator);
}
