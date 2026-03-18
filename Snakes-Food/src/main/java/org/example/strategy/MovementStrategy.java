package org.example.strategy;

import org.example.entity.Pair;

public interface MovementStrategy {
    Pair getNextPosition(Pair currentHead, String direction);
}