package org.example.strategy;

import org.example.entity.Cell;
import org.example.singleton.Board;

public class QueenMovementStrategy implements MovementStrategy {
    private RookMovementStrategy rookStrategy = new RookMovementStrategy();
    private BishopMovementStrategy bishopStrategy = new BishopMovementStrategy();

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        // Queen can move like a rook or bishop
        return rookStrategy.canMove(board, startCell, endCell) || 
               bishopStrategy.canMove(board, startCell, endCell);
    }
}
