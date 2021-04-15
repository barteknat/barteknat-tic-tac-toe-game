package com.kodilla.tictactoe.strategy;

import com.kodilla.tictactoe.model.Board;
import com.kodilla.tictactoe.model.Figure;
import com.kodilla.tictactoe.uix.UserInterface;

public class EnemyStrategy implements Strategy {

    private final Board board;

    public EnemyStrategy(UserInterface userInterface) {
        this.board = new Board(userInterface);
    }

    public Figure getMove(int row, int col, Figure figure) {

        return Board.board[row][col] = figure;
    }
}

