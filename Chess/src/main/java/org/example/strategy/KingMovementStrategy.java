package org.example.strategy;

import org.example.entity.Cell;
import org.example.singleton.Board;

public class KingMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return false;
    }
}
