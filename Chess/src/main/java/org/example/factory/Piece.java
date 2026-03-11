package org.example.factory;

import org.example.entity.Cell;
import org.example.singleton.Board;
import org.example.strategy.MovementStrategy;

public abstract class Piece {
    private boolean isWhitePiece;
    private boolean killed = false;
    private MovementStrategy movementStrategy;
    public Piece(boolean isWhitePiece, MovementStrategy movementStrategy) {
        this.isWhitePiece = isWhitePiece;
        this.movementStrategy = movementStrategy;
    }

    public boolean isWhite() {
        return isWhitePiece;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean canMove(Board board, Cell startBlock, Cell endBlock) {
        return movementStrategy.canMove(board, startBlock, endBlock);
    }
}