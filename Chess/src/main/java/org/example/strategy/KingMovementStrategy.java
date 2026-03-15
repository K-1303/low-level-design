package org.example.strategy;

import org.example.entity.Cell;
import org.example.singleton.Board;

public class KingMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        int startRow = startCell.getRow();
        int startCol = startCell.getCol();
        int endRow = endCell.getRow();
        int endCol = endCell.getCol();

        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);

        // King moves one square in any direction
        if (rowDiff > 1 || colDiff > 1 || (rowDiff == 0 && colDiff == 0)) {
            return false; // Invalid king move or same cell
        }

        // Check destination cell
        if (endCell.getPiece() != null) {
            return startCell.getPiece().isWhite() != endCell.getPiece().isWhite();
        }

        return true;
    }
}
