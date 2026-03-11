package org.example.factory;

import org.example.entity.Cell;
import org.example.singleton.Board;
import org.example.strategy.KingMovementStrategy;

public class King extends Piece {
    public King(boolean white) {
        super(white, new KingMovementStrategy());
    }

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return super.canMove(board, startCell, endCell);
    }
}
