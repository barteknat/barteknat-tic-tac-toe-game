package com.kodilla.tictactoe.model;

import com.kodilla.tictactoe.uix.UserInterface;

public class Board {

    public final static Figure[][] board = new Figure[3][3];
    private final UserInterface userInterface;

    public Board(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public boolean isAllowed(int i, int j) {
        return board[i][j] == null;
    }

    public void viewer() {
        int c = 0;
        userInterface.printRawIndex();
        for (int i = 0; i < board.length; i++) {
            userInterface.printColumnIndex(c++);
            if (c == 3) {
                c = 0;
            }
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == null) {
                    userInterface.printEmptyField();
                } else {
                    userInterface.printBoard(board, i, j);
                }
            }
            userInterface.printEmptyLine();
        }
    }

    public void resetBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = null;
            }
        }
    }
}

