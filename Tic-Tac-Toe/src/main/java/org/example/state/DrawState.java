package org.example.state;

import org.example.GameContext;
import org.example.entity.Board;
import org.example.entity.Player;
import org.example.enums.Symbol;

public class DrawState implements GameState {
    @Override
    public void next(GameContext context, Player player, boolean hasWon, Board board) {
        // Game over, no next state
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
