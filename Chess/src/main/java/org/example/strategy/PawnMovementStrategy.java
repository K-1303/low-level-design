package org.example.strategy;

import org.example.entity.Cell;
import org.example.singleton.Board;

public class PawnMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        int startRow = startCell.getRow();
        int startCol = startCell.getCol();
        int endRow = endCell.getRow();
        int endCol = endCell.getCol();

        boolean isWhite = startCell.getPiece().isWhite();
        int direction = isWhite ? 1 : -1; // White moves down (increasing row), Black moves up (decreasing row)
        int startingRow = isWhite ? 1 : 6; // White starts at row 1, Black at row 6

        // Pawn can move forward 1 square or 2 squares on first move
        if (startCol == endCol) {
            if (endCell.getPiece() != null) {
                return false; // Cannot capture forward
            }

            int rowDiff = endRow - startRow;
            if (rowDiff == direction) {
                return true; // Move one square forward
            }

            if (startRow == startingRow && rowDiff == 2 * direction) {
                Cell intermediateCell = board.getCell(startRow + direction, startCol);
                return intermediateCell != null && intermediateCell.getPiece() == null;
            }

            return false;
        }

        // Pawn captures diagonally
        if (Math.abs(startCol - endCol) == 1 && (endRow - startRow) == direction) {
            if (endCell.getPiece() != null) {
                return isWhite != endCell.getPiece().isWhite();
            }
            return false; // No piece to capture
        }

        return false;
    }
}
