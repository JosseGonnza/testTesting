package com.jossegonnza.junit_project.game;

public class ScoreBoard {

    private Integer ties;
    private Integer wins;
    private Integer losses;

    public ScoreBoard() {
        ties = 0;
        wins = 0;
        losses = 0;
    }

    public Integer getTies() {
        return ties;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void incrementWins() {
        wins++;
    }

    public void incrementLosses() {
        losses++;
    }

    public void incrementTies() {
        ties++;
    }

}
