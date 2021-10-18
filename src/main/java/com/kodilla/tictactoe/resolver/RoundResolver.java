package com.kodilla.tictactoe.resolver;

import com.kodilla.tictactoe.model.Board;
import com.kodilla.tictactoe.model.Figure;
import com.kodilla.tictactoe.model.RoundResult;

import static com.kodilla.tictactoe.model.RoundResult.*;

public class RoundResolver implements Resolver {

    @Override
    public RoundResult resolve(Figure figure) {
        for (int i = 0; i < Board.board.length; i++) {
            if (isInLine(figure, i))
                return WIN;
        }
        for (int i = 0; i < Board.board.length; i++) {
            for (int j = 0; j < Board.board.length; j++) {
                if (Board.board[i][j] == null) return NOBODY;
            }
        }
        return DRAW;
    }

    private boolean isInLine(Figure figure, int i) {
        return Board.board[i][0] == Board.board[i][1] && Board.board[i][1] == Board.board[i][2] && Board.board[i][2] == figure ||
                Board.board[0][i] == Board.board[1][i] && Board.board[1][i] == Board.board[2][i] && Board.board[2][i] == figure ||
                Board.board[0][0] == Board.board[1][1] && Board.board[1][1] == Board.board[2][2] && Board.board[2][2] == figure ||
                Board.board[2][0] == Board.board[1][1] && Board.board[1][1] == Board.board[0][2] && Board.board[0][2] == figure;
    }
}

