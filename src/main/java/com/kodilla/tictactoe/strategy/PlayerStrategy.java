package com.kodilla.tictactoe.strategy;

import com.kodilla.tictactoe.model.Board;
import com.kodilla.tictactoe.model.Figure;
import com.kodilla.tictactoe.uix.UserInterface;

public class PlayerStrategy implements Strategy {

    private final Board board;
    private final UserInterface userInterface;

    public PlayerStrategy(UserInterface userInterface) {
        this.userInterface = userInterface;
        this.board = new Board(userInterface);
    }

    @Override
    public Figure getMove(int row, int col, Figure figure) {
        return Board.board[row][col] = figure;
    }
}

