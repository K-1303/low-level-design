package org.example;

import org.example.entity.Player;
import org.example.state.GameState;
import org.example.state.XTurnState;

public class GameContext {
    private GameState currentState;

    public GameContext() {
        currentState = new XTurnState();
    }

    public void setState(GameState state) {
        this.currentState = state;
    }

    public void next(Player player, boolean hasWon) {
        currentState.next(this, player, hasWon);
    }

    public  boolean isGameOver() {
        return currentState.isGameOver();
    }

    public GameState getCurrentState() {
        return currentState;
    }
}
