package genspark.John_Manuel;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class App {
    public static void main( String[] args ) {
        Guess newGame = new Guess();
        String playerName = newGame.onStart();

        newGame.runGame(playerName);
    }
}