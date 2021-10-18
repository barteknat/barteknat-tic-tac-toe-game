package com.kodilla.tictactoe.resolver;

import com.kodilla.tictactoe.model.Figure;
import com.kodilla.tictactoe.model.RoundResult;

public interface Resolver {

    RoundResult resolve(Figure figure);
}

