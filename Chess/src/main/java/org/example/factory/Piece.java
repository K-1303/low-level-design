package org.example.factory;

public abstract class Piece {
    private boolean isWhitePiece;
    private boolean killed = false;

    public Piece(boolean isWhitePiece) {
        this.isWhitePiece = isWhitePiece;
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
}