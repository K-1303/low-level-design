package org.example.observer;

import org.example.entity.Position;
import org.example.enums.Symbol;
import org.example.state.GameState;

public class ConsoleGameEventListener implements GameEventListener {
    @Override
    public void onMoveMade(Position position, Symbol symbol) {
        System.out.println("Move made at position: " + position + " by " + symbol);
    }
    @Override
    public void onGameStateChanged(GameState state) {
        System.out.println("Game state changed to: " + state);
    }
}
