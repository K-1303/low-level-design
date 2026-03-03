package org.example.state;

import org.example.GameContext;
import org.example.entity.Player;
import org.example.enums.Symbol;

public class XTurnState implements GameState{
    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        if(hasWon) {
            context.setState(player.getSymbol() == Symbol.X ? new XWonState() : new OWonState());
        } else {
            context.setState(new OTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
