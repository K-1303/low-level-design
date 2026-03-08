package org.example.state;

import org.example.GameContext;
import org.example.entity.Board;
import org.example.entity.Player;
import org.example.enums.Symbol;

public class OTurnState implements GameState{
    @Override
    public void next(GameContext context, Player player, boolean hasWon, Board board) {
        GameState newState;
        if(hasWon) newState = player.getSymbol() == Symbol.X ? new XWonState() : new OWonState();
        else newState = new XTurnState();

        context.setState(newState);
        board.notifyGameStateChanged(newState);
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
