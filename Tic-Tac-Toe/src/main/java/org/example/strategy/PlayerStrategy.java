package org.example.strategy;

import org.example.entity.Board;
import org.example.entity.Position;

public interface PlayerStrategy {
    Position makeMove(Board board);
}