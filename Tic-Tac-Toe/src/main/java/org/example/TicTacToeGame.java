package org.example;

import org.example.entity.Board;
import org.example.entity.Player;
import org.example.entity.Position;
import org.example.enums.Symbol;
import org.example.observer.GameEventListener;
import org.example.state.GameState;
import org.example.state.OWonState;
import org.example.state.XWonState;
import org.example.strategy.PlayerStrategy;

public class TicTacToeGame implements BoardGames{
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameContext gameContext;

    public TicTacToeGame(PlayerStrategy xStrategy, PlayerStrategy oStrategy,
                         int rows, int columns, GameEventListener listener) {
        board = new Board(rows, columns);
        board.addListener(listener);
        playerX = new Player(Symbol.X, xStrategy);
        playerO = new Player(Symbol.O, oStrategy);
        currentPlayer = playerX;
        gameContext = new GameContext();
    }

    @Override
    public void play() {
        do {
            board.printBoard();

            Position move = currentPlayer.getPlayerStrategy().makeMove(board);

            board.makeMove(move, currentPlayer.getSymbol());

            board.checkGameState(gameContext, currentPlayer);
            switchPlayer();
        } while(!gameContext.isGameOver());

        announceResult();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    private void announceResult() {
        GameState state = gameContext.getCurrentState();
        if (state instanceof XWonState) {
            System.out.println("Player X wins!");
        } else if (state instanceof OWonState) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
