package org.example.factory;

import org.example.entity.Cell;
import org.example.singleton.Board;
import org.example.strategy.KingMovementStrategy;
import org.example.strategy.RookMovementStrategy;

public class Rook extends Piece {
    public Rook(boolean white) {
        super(white, new RookMovementStrategy());
    }

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return super.canMove(board, startCell, endCell);
    }
}
