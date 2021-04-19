package com.kodilla.tictactoe.uix;

import com.kodilla.tictactoe.model.*;

public class SimpleUserInterface implements UserInterface {

    private static Figure playerFigure;
    private static Figure enemyFigure;

    @Override
    public String printWelcome() {
        return "xoxoxoxoxoxoxoxoxoxox \n" +
                "     WELCOME TO THE \n" +
                "xoxoxoxoxoxoxoxoxoxox \n" +
                "           TIC TAC TOE \n" +
                "xoxoxoxoxoxoxoxoxoxox \n";
    }

    @Override
    public void setPlayerFigure(Figure figure) {
        playerFigure = figure;
    }

    @Override
    public void setEnemyFigure() {
        if (playerFigure == Figure.FIGURE_X) {
            enemyFigure = Figure.FIGURE_O;
        } else {
            enemyFigure = Figure.FIGURE_X;
        }
    }

    @Override
    public Figure getPlayerFigure() {
        return playerFigure;
    }

    @Override
    public Figure getEnemyFigure() {
        return enemyFigure;
    }

    @Override
    public void resetFigures() {
        this.playerFigure = null;
        this.enemyFigure = null;
    }

    @Override
    public void printRoundInform(int number, Winner player) {
        System.out.println("-------------------- \nROUND " + number + "\n" + player + " TURN");
    }

    @Override
    public void printDraw(RoundResult result) {
        System.out.println(result);
    }

    @Override
    public String printRoundResult(Winner player, RoundResult result, int playerWins, int enemyWins) {
        System.out.println("\n" + player + " " + result +
                "\nPlayer wins:   " + playerWins +
                "\nEnemy wins:    " + enemyWins);
        return player + " " + result;
    }

    @Override
    public void printRawIndex() {
        System.out.println("   0 " + " 1 " + " 2");
    }

    @Override
    public void printColumnIndex(int c) {
        System.out.print(c + " ");
    }

    @Override
    public void printEmptyField() {
        System.out.print("[ ]");
    }

    @Override
    public void printBoard(Figure[][] board, int i, int j) {
        System.out.print("[" + board[i][j] + "]");
    }

    @Override
    public void printEmptyLine() {
        System.out.println();
    }
}
