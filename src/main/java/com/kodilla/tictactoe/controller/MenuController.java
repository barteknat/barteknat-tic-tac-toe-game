package com.kodilla.tictactoe.controller;

import com.kodilla.tictactoe.model.Figure;
import com.kodilla.tictactoe.uix.SimpleUserInterface;
import com.kodilla.tictactoe.uix.UserInterface;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MenuController {

    private MainController mainController;
    private final UserInterface userInterface = new SimpleUserInterface();
    @FXML
    private Label welcome;
    @FXML
    private RadioButton o;
    @FXML
    private RadioButton x;

    public void getWelcome() {
        welcome.setText(userInterface.printWelcome());
    }

    @FXML
    public void getO() {
        userInterface.setPlayerFigure(Figure.o);
        userInterface.setEnemyFigure();
        o.setDisable(true);
        x.setDisable(true);
        userInterface.getEnemyFigure();
    }

    @FXML
    public void getX() {
        userInterface.setPlayerFigure(Figure.x);
        userInterface.setEnemyFigure();
        o.setDisable(true);
        x.setDisable(true);
        userInterface.getEnemyFigure();
    }

    public void initialize() {
        getWelcome();
    }

    @FXML
    public void getStart() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/GameScreen.fxml"));
        BorderPane borderPane = null;
        try {
            borderPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameController gameController = loader.getController();
        gameController.drawBoard();
        gameController.setMainController(this.mainController);
        gameController.setMenuController(this);
        this.mainController.setScreen(borderPane);
    }

    @FXML
    public void getExit() {
        Platform.exit();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}

