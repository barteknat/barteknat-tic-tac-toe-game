package com.kodilla.tictactoe.model;

public class GameDefinition {

    private final String username;
    private final int rounds;

    public GameDefinition(String username, int rounds) {
        this.username = username;
        this.rounds = rounds;
    }

    public String getUsername() {
        return username;
    }

    public int getRounds() {
        return rounds;
    }

    @Override
    public String toString() {
        return "\nSUM UP:" +
                "\nusername      = " + username +
                "\ngames to win  = " + rounds;
    }
}

