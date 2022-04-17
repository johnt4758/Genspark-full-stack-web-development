package john_manuel.genspark;

import john_manuel.genspark.utils.RandomWord;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunTest
{
    Character[] lettersFoundInWord;

    int numOfWrongGuesses;

    String wordToGuess;

    boolean isDone = false;

    final List<String> playerGuessedLetters = new ArrayList<>();

    RandomWord chosenWord = new RandomWord();

    @Test
    public void newGame(){
        isDone = false;
        chosenWord.setNewChosenWord();
        wordToGuess = chosenWord.getChosenWord();
        numOfWrongGuesses = 0;
        playerGuessedLetters.clear();
        lettersFoundInWord = new Character[wordToGuess.length()];

        lettersFoundInWord = Stream.of(lettersFoundInWord).map(i -> '_').collect(Collectors.toList()).toArray(Character[]::new);
    }

    @Test
    private void randomWordBuilder(){
        StringBuilder wordBuiler = new StringBuilder();

        wordBuiler.append(Arrays.stream(lettersFoundInWord).map(l -> l + " "));

        System.out.println(wordBuiler.toString());
    }
}
