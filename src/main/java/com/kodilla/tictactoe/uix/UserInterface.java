package com.kodilla.tictactoe.uix;

import com.kodilla.tictactoe.model.*;

public interface UserInterface {

    String printWelcome();

    void setPlayerFigure(Figure figure);

    void setEnemyFigure();

    Figure getPlayerFigure();

    Figure getEnemyFigure();

    void resetFigures();

    void printRoundInform(int number, Winner player);

    void printDraw(RoundResult result);

    String printRoundResult(Winner player, RoundResult result, int playerWins, int enemyWins);

    void printRawIndex();

    void printColumnIndex(int c);

    void printEmptyField();

    void printBoard(Figure[][] board, int i, int j);

    void printEmptyLine();

}


