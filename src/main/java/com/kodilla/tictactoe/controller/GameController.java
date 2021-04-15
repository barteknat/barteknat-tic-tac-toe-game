package com.kodilla.tictactoe.controller;

import com.kodilla.tictactoe.model.*;
import com.kodilla.tictactoe.round.EnemyRound;
import com.kodilla.tictactoe.round.PlayerRound;
import com.kodilla.tictactoe.round.Round;
import com.kodilla.tictactoe.uix.SimpleUserInterface;
import com.kodilla.tictactoe.uix.UserInterface;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Random;

import static com.kodilla.tictactoe.model.RoundResult.DRAW;
import static com.kodilla.tictactoe.model.RoundResult.WIN;
import static com.kodilla.tictactoe.model.Winner.ENEMY;
import static com.kodilla.tictactoe.model.Winner.PLAYER;

public class GameController {

    @FXML
    Canvas canvasBoard;
    @FXML
    Label win;
    private final static Random random = new Random();
    private MainController mainController;
    private MenuController menuController;
    private final UserInterface userInterface = new SimpleUserInterface();
    private final Board modelBoard = new Board(userInterface);
    private final Statistics statistics = new Statistics();
    private final Round playerRound = new PlayerRound(statistics, userInterface);
    private final Round enemyRound = new EnemyRound(statistics, userInterface);

    public void drawBoard() {
        GraphicsContext g = canvasBoard.getGraphicsContext2D();
        g.setLineWidth(5);
        g.setStroke(Color.DODGERBLUE);
        g.strokeLine(150, 50, 150, 350);
        g.strokeLine(250, 50, 250, 350);
        g.strokeLine(50, 150, 350, 150);
        g.strokeLine(50, 250, 350, 250);
    }

    @FXML
    public void mouseAction(MouseEvent event) {
        GraphicsContext g = canvasBoard.getGraphicsContext2D();
        resolve(g, event.getX(), event.getY());
    }

    private void resolve(GraphicsContext g, double x, double y) {
        int row = 0;
        int col = 0;
        if (x > 50 && x < 350 && y > 50 && y < 350) {
            row = (int) ((y - 50) / 100);
            col = (int) ((x - 50) / 100);
        }
        if (!modelBoard.isAllowed(row, col)) return;
        drawFigure(g, userInterface.getPlayerFigure(), row, col);
        RoundResult result = playerRound.play(row, col);
        if (result != WIN && result != DRAW) {
            getEnemyMove(g);
        }
        if (result == WIN || result == DRAW) {
            getRoundInfo(PLAYER, result);
            canvasBoard.setDisable(true);
        }
    }

    public void getEnemyMove(GraphicsContext g) {
        int row = random.nextInt(3);
        int col = random.nextInt(3);
        while (!modelBoard.isAllowed(row, col)) {
            row = random.nextInt(3);
            col = random.nextInt(3);
        }
        drawFigure(g, userInterface.getEnemyFigure(), row, col);
        RoundResult result = enemyRound.play(row, col);
        if (result == WIN) {
            getRoundInfo(ENEMY, result);
            canvasBoard.setDisable(true);
        }
    }

    public void drawFigure(GraphicsContext g, Figure figure, int x, int y) {
        if (figure == Figure.x) {
            g.setStroke(Color.LIGHTSEAGREEN);
            g.strokeLine(70 + y * 100, 70 + x * 100, 130 + y * 100, 130 + x * 100);
            g.strokeLine(70 + y * 100, 130 + x * 100, 130 + y * 100, 70 + x * 100);
        } else if (figure == Figure.o) {
            g.setStroke(Color.DARKSLATEBLUE);
            g.strokeOval(65 + y * 100, 65 + x * 100, 70, 70);
        }
    }

    @FXML
    public void getRoundInfo(Winner winner, RoundResult result) {
        if (result == DRAW) {
            win.setText(String.valueOf(result));
        } else if (userInterface.getPlayerFigure() == null && userInterface.getEnemyFigure() == null) {
            win.setText("choose figure");
        } else if (result == WIN) {
            win.setText(winner + " " + result);
        }
    }

    @FXML
    public void getBack() {
        userInterface.resetFigures();
        modelBoard.resetBoard();
        mainController.loadMenuScreen();
    }

    @FXML
    public void reset() {
        modelBoard.resetBoard();
        menuController.getStart();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
}

