package john_manuel.genspark;

import john_manuel.genspark.utils.RandomWord;

import java.util.ArrayList;
import java.util.List;

public class Hangman {

    private char[] lettersFoundInWord;

    private int numOfWrongGuesses;

    private String wordToGuess;

    private final List<String> playerGuessedLetters = new ArrayList<>();

    RandomWord chosenWord = new RandomWord();

    public Hangman(){

    }

    public void start(){

    }

    public void newGame(){

    }
}
