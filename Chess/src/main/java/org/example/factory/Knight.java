package org.example.factory;

import org.example.entity.Cell;
import org.example.singleton.Board;
import org.example.strategy.KnightMovementStrategy;

public class Knight extends Piece {
    public Knight(boolean white) {
        super(white, new KnightMovementStrategy());
    }

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return super.canMove(board, startCell, endCell);
    }
}