package org.example.strategy;

import org.example.entity.Cell;
import org.example.singleton.Board;

public class RookMovementStrategy implements MovementStrategy{
    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        int startRow = startCell.getRow();
        int startCol = startCell.getCol();
        int endRow = endCell.getRow();
        int endCol = endCell.getCol();

        // Rook moves horizontally or vertically
        if (startRow != endRow && startCol != endCol) {
            return false; // Not a straight line
        }

        if (startRow == endRow && startCol == endCol) {
            return false; // Same cell
        }

        // Check path is clear
        int rowDirection = Integer.compare(endRow, startRow);
        int colDirection = Integer.compare(endCol, startCol);

        int currentRow = startRow + rowDirection;
        int currentCol = startCol + colDirection;

        while (currentRow != endRow || currentCol != endCol) {
            Cell currentCell = board.getCell(currentRow, currentCol);
            if (currentCell != null && currentCell.getPiece() != null) {
                return false; // Path is blocked
            }
            currentRow += rowDirection;
            currentCol += colDirection;
        }

        // Check destination cell
        if (endCell.getPiece() != null) {
            return startCell.getPiece().isWhite() != endCell.getPiece().isWhite();
        }

        return true;
    }
}
