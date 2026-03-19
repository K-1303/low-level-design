package org.example.strategy;

import org.example.Pair;

public interface MovementStrategy {
    Pair getNextPosition(Pair currentHead, String direction);
}