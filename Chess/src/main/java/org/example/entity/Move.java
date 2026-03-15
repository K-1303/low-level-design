package org.example.entity;
import org.example.factory.Piece;

public class Move {
    private Cell startCell;
    private Cell endCell;

    public Move(Cell startCell, Cell endCell) {
        this.startCell = startCell;
        this.endCell = endCell;
    }

    public boolean isValid() {
        Piece startPiece = startCell.getPiece();
        Piece endPiece = endCell.getPiece();
        
        if (startPiece == null) {
            return false;
        }
        
        if (endPiece == null) {
            return true;
        }
        
        return startPiece.isWhite() != endPiece.isWhite();
    }

    public Cell getStartCell() {
        return startCell;
    }

    public Cell getEndCell() {
        return endCell;
    }
}