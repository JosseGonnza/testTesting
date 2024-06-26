package com.jossegonnza.junit_project.game;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    public void play() {
        printGameRules();

        ScoreBoard scoreBoard = new ScoreBoard();
        String choice = input.nextLine().toUpperCase();

        while (!choice.equals("QUIT"))
        {
            GameOption choicenum = getChoiceNum(choice);
            if (choicenum == null) {
                    System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
                    choice = input.nextLine().toUpperCase();
                    choicenum = getChoiceNum(choice);
            }
            GameOption compnum = getChoiceComputer();

            completeGamePlay(choicenum, compnum, scoreBoard);

            printResults(scoreBoard);
            choice = input.nextLine().toUpperCase();
        }
    }

    private static void printResults(ScoreBoard scoreBoard) {
        System.out.println("wins:" + scoreBoard.getWins() + "\nloses:" + scoreBoard.getLosses() + "\nties:" +
                scoreBoard.getTies());
        System.out.println("Let's play again! \n \n");
        System.out.println(
                "Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private static void completeGamePlay(GameOption choicenum, GameOption compnum, ScoreBoard scoreBoard) {
        if(choicenum == compnum)
        {
            ties(scoreBoard);
        }
        else if (choicenum == GameOption.ROCK && compnum == GameOption.SCISSORS
                || choicenum == GameOption.SCISSORS && compnum == GameOption.PAPER
                || choicenum == GameOption.PAPER && compnum == GameOption.ROCK) {
            wins(scoreBoard);
        }
        lose(scoreBoard);
    }

    private static void lose(ScoreBoard scoreBoard) {
        System.out.println("you lose.");
        scoreBoard.incrementLosses();
    }

    private static void ties(ScoreBoard scoreBoard) {
        System.out.println("It's a tie");
        scoreBoard.incrementTies();
    }

    private static void wins(ScoreBoard scoreBoard) {
        System.out.println("you win!");
        scoreBoard.incrementWins();
    }

    private GameOption getChoiceNum(String choice) {
        GameOption selectedOption = null;

        if (choice.equals("quit"))
            System.exit(0);

        try {
            selectedOption = GameOption.valueOf(choice);
        } catch (Exception e) {
            return null;
        }
            return selectedOption;
    }

    private GameOption getChoiceComputer() {

        GameOption option = GameOption.values()[random.nextInt(3)];
        System.out.println("Computer chose " + option.toString().toLowerCase());
        return option;
    }

    private static void printGameRules() {
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println(
                "Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }
}
