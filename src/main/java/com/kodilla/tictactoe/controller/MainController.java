package com.kodilla.tictactoe.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainController {

    @FXML
    private StackPane mainScreen;

    @FXML
    public void initialize() {
        loadMenuScreen();
    }

    public void loadMenuScreen() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MenuScreen.fxml"));
        BorderPane menuScreen = null;
        try {
            menuScreen = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuController menuController = loader.getController();
        menuController.setMainController(this);
        setScreen(menuScreen);
    }

    public void setScreen(Pane pane) {
        mainScreen.getChildren().clear();
        mainScreen.getChildren().add(pane);
    }
}

