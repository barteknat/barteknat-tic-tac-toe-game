package com.kodilla.tictactoe.round;

import com.kodilla.tictactoe.model.*;
import com.kodilla.tictactoe.resolver.Resolver;
import com.kodilla.tictactoe.resolver.RoundResolver;
import com.kodilla.tictactoe.strategy.EnemyStrategy;
import com.kodilla.tictactoe.uix.UserInterface;

import static com.kodilla.tictactoe.model.RoundResult.DRAW;
import static com.kodilla.tictactoe.model.RoundResult.WIN;
import static com.kodilla.tictactoe.model.Winner.ENEMY;

public class EnemyRound implements Round {

    private final int number;
    private final Statistics statistics;
    private final UserInterface userInterface;
    private final Board board;
    private final EnemyStrategy enemyStrategy;
    private final Resolver resolver;

    public EnemyRound(Statistics statistics, UserInterface userInterface) {
        this.number = statistics.getRounds() + 1;
        this.statistics = statistics;
        this.userInterface = userInterface;
        this.board = new Board(userInterface);
        this.enemyStrategy = new EnemyStrategy(userInterface);
        this.resolver = new RoundResolver();
    }

    public RoundResult play(int row, int col) {
        Figure enemyFigure = userInterface.getEnemyFigure();
        userInterface.printRoundInform(number, ENEMY);
        enemyStrategy.getMove(row, col, enemyFigure);
        board.viewer();
        RoundResult result = resolver.resolve(enemyFigure);
        updateStatistics(ENEMY, result);
        return result;
    }

    public void updateStatistics(Winner player, RoundResult result) {
        if (result == DRAW) {
            statistics.incrementDraws();
            statistics.incrementRounds();
            userInterface.printDraw(result);
            board.resetBoard();
        }
        if (result == WIN) {
            statistics.incrementLoses();
            statistics.incrementRounds();
            userInterface.printRoundResult(player, result, statistics.getWins(), statistics.getLoses());
            board.resetBoard();
        }
    }
}

