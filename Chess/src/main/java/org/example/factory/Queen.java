package org.example.factory;

import org.example.entity.Cell;
import org.example.singleton.Board;
import org.example.strategy.QueenMovementStrategy;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white, new QueenMovementStrategy());
    }
    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return super.canMove(board, startCell, endCell);
    }
}
