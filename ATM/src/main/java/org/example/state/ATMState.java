package org.example.state;

import org.example.entity.ATMMachineContext;

public interface ATMState {
    // Get the name of the current state
    String getStateName();

    // Method to handle state transitions
    ATMState next(ATMMachineContext context);
}