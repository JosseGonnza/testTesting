package com.jossegonnza.junit_project.game;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @InjectMocks
    private Game game;

    @Mock
    Scanner scanner;

    @Test
    public void when_WriteQuit_then_exitGame() {

        when(scanner.nextLine()).thenReturn("Quit");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        game.play();

        Assert.assertTrue(out.toString().contains("Let's play Rock, Paper, Scissors!"));

    }

    @Test
    public void when_chooseRock_then_beatsScissors() {

        when(scanner.nextLine()).thenReturn("Rock").thenReturn("Quit");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        game.play();

        Assert.assertTrue(out.toString().contains("Let's play Rock, Paper, Scissors!"));

    }

}
