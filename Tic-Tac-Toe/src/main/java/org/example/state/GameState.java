package org.example.state;


import org.example.GameContext;
import org.example.entity.Player;

public interface GameState {
    void next(GameContext context, Player player , boolean hasWon);
    boolean isGameOver();
}
