package com.kodilla.tictactoe.round;

import com.kodilla.tictactoe.model.RoundResult;
import com.kodilla.tictactoe.model.Winner;

public interface Round {

    RoundResult play(int row, int col);

    void updateStatistics(Winner player, RoundResult result);
}

