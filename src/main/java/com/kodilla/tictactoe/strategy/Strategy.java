package com.kodilla.tictactoe.strategy;

import com.kodilla.tictactoe.model.Figure;

public interface Strategy {

    Figure getMove(int row, int col, Figure figure);
}

