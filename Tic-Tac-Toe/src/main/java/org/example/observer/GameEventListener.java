package org.example.observer;

import org.example.entity.Position;
import org.example.enums.Symbol;
import org.example.state.GameState;

public interface GameEventListener {
    void onMoveMade(Position position, Symbol symbol);
    void onGameStateChanged(GameState state);
}