package org.example.strategy;

import org.example.entity.Cell;
import org.example.singleton.Board;

public class KnightMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        int startRow = startCell.getRow();
        int startCol = startCell.getCol();
        int endRow = endCell.getRow();
        int endCol = endCell.getCol();

        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);

        // Knight moves in L-shape: 2 squares in one direction and 1 square perpendicular
        if (!((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2))) {
            return false; // Not a valid knight move
        }

        // Check destination cell
        if (endCell.getPiece() != null) {
            return startCell.getPiece().isWhite() != endCell.getPiece().isWhite();
        }

        return true; // Knights can jump over pieces
    }
}
