package org.example.strategy;

import org.example.entity.Cell;
import org.example.singleton.Board;

public interface MovementStrategy {
    boolean canMove(Board board, Cell startCell, Cell endCell);
}
