package com.kodilla.tictactoe.round;

import com.kodilla.tictactoe.model.*;
import com.kodilla.tictactoe.resolver.Resolver;
import com.kodilla.tictactoe.resolver.RoundResolver;
import com.kodilla.tictactoe.strategy.PlayerStrategy;
import com.kodilla.tictactoe.strategy.Strategy;
import com.kodilla.tictactoe.uix.UserInterface;

import static com.kodilla.tictactoe.model.RoundResult.*;
import static com.kodilla.tictactoe.model.Winner.PLAYER;

public class PlayerRound implements Round {

    private final int number;
    private final Statistics statistics;
    private final UserInterface userInterface;
    private final Board board;
    private final Strategy playerStrategy;
    private final Resolver resolver;

    public PlayerRound(Statistics statistics, UserInterface userInterface) {
        this.number = statistics.getRounds() + 1;
        this.statistics = statistics;
        this.userInterface = userInterface;
        this.board = new Board(userInterface);
        this.playerStrategy = new PlayerStrategy(userInterface);
        this.resolver = new RoundResolver();
    }

    @Override
    public RoundResult play(int row, int col) {
        Figure playerFigure = userInterface.getPlayerFigure();
        userInterface.printRoundInform(number, PLAYER);
        playerStrategy.getMove(row, col, playerFigure);
        board.viewer();
        RoundResult result = resolver.resolve(playerFigure);
        updateStatistics(PLAYER, result);
        return result;
    }

    @Override
    public void updateStatistics(Winner player, RoundResult result) {
        if (result == DRAW) {
            statistics.incrementDraws();
            statistics.incrementRounds();
            userInterface.printDraw(result);
            board.resetBoard();
        }
        if (result == WIN) {
            statistics.incrementWins();
            statistics.incrementRounds();
            userInterface.printRoundResult(player, result, statistics.getWins(), statistics.getLoses());
            board.resetBoard();
        }
    }
}

