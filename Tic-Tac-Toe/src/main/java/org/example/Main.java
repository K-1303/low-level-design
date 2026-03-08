package org.example;

import org.example.observer.ConsoleGameEventListener;
import org.example.observer.GameEventListener;
import org.example.strategy.HumanPlayerStrategy;
import org.example.strategy.PlayerStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlayerStrategy playerXStrategy = new HumanPlayerStrategy("Player X");
        PlayerStrategy playerOStrategy = new HumanPlayerStrategy("Player O");
        GameEventListener consoleEventListener = new ConsoleGameEventListener();
        TicTacToeGame game = new TicTacToeGame(playerXStrategy, playerOStrategy, 3, 3, consoleEventListener);
        game.play();
    }
}