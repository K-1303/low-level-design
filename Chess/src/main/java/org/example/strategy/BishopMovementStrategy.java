package org.example.strategy;

import org.example.entity.Cell;
import org.example.singleton.Board;

public class BishopMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        int startRow = startCell.getRow();
        int startCol = startCell.getCol();
        int endRow = endCell.getRow();
        int endCol = endCell.getCol();

        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);
        
        if (rowDiff != colDiff || rowDiff == 0) {
            return false;
        }

        int rowDirection = Integer.compare(endRow, startRow);
        int colDirection = Integer.compare(endCol, startCol);

        int currentRow = startRow + rowDirection;
        int currentCol = startCol + colDirection;

        while (currentRow != endRow || currentCol != endCol) {
            Cell currentCell = board.getCell(currentRow, currentCol);
            if (currentCell != null && currentCell.getPiece() != null) {
                return false;
            }
            currentRow += rowDirection;
            currentCol += colDirection;
        }

        // Check destination cell
        if (endCell.getPiece() != null) {
            // Can only move to destination if it contains an opponent's piece
            return startCell.getPiece().isWhite() != endCell.getPiece().isWhite();
        }

        return true; // Valid move
    }
}
