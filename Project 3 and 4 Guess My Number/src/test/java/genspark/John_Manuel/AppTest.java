package genspark.John_Manuel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Scanner;

public class AppTest
{
    Guess newRun;

    ArrayList<Integer> sudoGuesses = new ArrayList<>();

    Scanner userInput = new Scanner(System.in);

    @BeforeEach
    void setUp() {
        newRun = new Guess();
        int maxGuess = 6;

        //making a list of fake guesses
        for(int i=0; i<maxGuess; i++){
            sudoGuesses.add(i);
        }
    }

    @Test
    public void testOnStart() {
        //testing to see if the start message pops up like it should
        //prompting the user for their name
        String playerName = newRun.onStart();
    }

    @Test
    public void testRunGame(){
        //I want to test the game as a whole here by passing in the list of fake player guesses
        //For speed I also want to pass in the player name statically
        String playerName = newRun.onStart();
        newRun.runGame(playerName);
    }

    @AfterEach
    void tearDown(){
        //closing down scanner to get a new one each time the test is run
        userInput.close();
    }
}
