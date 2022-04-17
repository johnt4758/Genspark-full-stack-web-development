package john_manuel.genspark;

import john_manuel.genspark.utils.RandomWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Hangman {

    private Character[] lettersFoundInWord;

    private int numOfWrongGuesses;

    private String wordToGuess;

    private boolean isDone;
    public boolean wordFound(){return wordToGuess.contentEquals(Arrays.toString(lettersFoundInWord));}

    private final List<String> playerGuessedLetters = new ArrayList<>();

    RandomWord chosenWord = new RandomWord();

    GameBoard board = new GameBoard();


    public Hangman(){

    }

    public void start(){
        //display board art from file
        board.getBoard();

        try{
            Scanner userInput = new Scanner(System.in);

            int maxNumOfWrongGuesses = 4;
            while(!isDone){
                while(numOfWrongGuesses < maxNumOfWrongGuesses){
                    //update row containing the "_" for blank spots
                    System.out.println(randomWordBuilder());

                    System.out.println("\nUsed Letters: " + playerGuessedLetters);

                    System.out.println("\nEnter a letter or 'quit' to stop: ");

                    String playerGuess = userInput.nextLine();

                    //added for the player to exit anytime during the game
                    //system exit is used a couple of times due to the library im using not closing its net connection
                    if(playerGuess.equals("quit")){
                        System.exit(0);
                    }
                    //if player entered a whole word, only use the first letter
                    else if(playerGuess.length() > 1){
                        playerGuess = playerGuess.substring(0, 1);
                    }

                    //add the letter to the player guessed letters list
                    updateLettersInWord(playerGuess);

                    if(wordFound()){
                        System.out.println("\n" + wordToGuess);
                        System.out.println("You Win!");
                        break;
                    }
                    else{
                        //update board and display
                    }
                }
                if(numOfWrongGuesses == maxNumOfWrongGuesses){
                    System.out.println("\nYou lost");
                    System.out.println("the word to guess was: " + wordToGuess);
                }
                System.out.println("Would you like to play again? (yes/no)");
                String playerContinue = userInput.nextLine();
                if(playerContinue.equals("yes")){
                    newGame();
                    start();
                }
                else if(playerContinue.equals("no")){
                    isDone = true;
                }
            }
            System.exit(0);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    //call new game to set all the scores back to zero
    public void newGame(){
        isDone = false;
        chosenWord.setNewChosenWord();
        wordToGuess = chosenWord.getChosenWord();
        numOfWrongGuesses = 0;
        playerGuessedLetters.clear();
        lettersFoundInWord = new Character[wordToGuess.length()];

        lettersFoundInWord = Stream.of(lettersFoundInWord).map(i -> '_').collect(Collectors.toList()).toArray(Character[]::new);
    }

    //Method to tidy up the array of '_' with spaces between each of them
    private String randomWordBuilder(){
        return String.valueOf(Arrays.stream(lettersFoundInWord).map(l -> l + " "));
    }

    private void updateLettersInWord(String letter){
        //check if player already guessed the letter
        if(!playerGuessedLetters.contains(letter)){
            //then check if the word has the letter
            if(wordToGuess.contains(letter)){
                //create index int based on where the letter is in the word
                final int[] index = {wordToGuess.indexOf(letter)};
                IntStream.range(0, index[0]).forEach(l -> {
                    lettersFoundInWord[index[0]] = letter.charAt(0);
                    index[0] = wordToGuess.indexOf(letter, index[0] + 1);});
            }
            else{
                numOfWrongGuesses++;
                //update board to add limb to person
            }
            //add guessed letter to player guessed letters list
            playerGuessedLetters.add(letter);
        }
    }
}
