package source;

import source.utils.RandomWord;
import source.utils.Drawing;

import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame {

    private char[] lettersFoundInWord;

    private final ArrayList<String> playerGuessedLetters = new ArrayList<>();

    private int wrongGuesses;

    private String wordToGuess;

    RandomWord generatedWord = new RandomWord();
    Drawing drawTool = new Drawing();
    StringBuilder board;

    public void start(){
        //set up the board using the custom drawing tool I created
        board = drawTool.boardDrawing();
        drawTool.displayBoard(board);

        //after board is set up and displayed for the start, start getting player input
        try{
            Scanner userInput = new Scanner(System.in);
            //setting the number of guesses until game over inside the start method since it doesn't need to be referenced anywhere else
            int maxNumOfWrongGuesses = 4;
            while(wrongGuesses < maxNumOfWrongGuesses){
                //update the line containing the blank spaces here
                System.out.println(randomWordBuilder());

                System.out.println("\nUsed letters: " + playerGuessedLetters);

                System.out.println("\nEnter a Letter or 'quit' to stop: ");

                String playerGuess = userInput.nextLine();

                //check if player types quit to exit the game early
                if(playerGuess.equals("quit")){
                    System.exit(0);
                }
                //only use the first letter of what the player entered
                //if more than one letter entered, make a new sub string with just the first one
                else if(playerGuess.length() > 1){
                    playerGuess = playerGuess.substring(0, 1);
                }
                //add the just guessed letter to player guesses array
                updateLettersInWord(playerGuess);

                if(wordFound()){
                    System.out.println("\nYou win!");
                    break;
                }
                else{
                    drawTool.displayBoard(board);
                }
            }

            if(wrongGuesses == maxNumOfWrongGuesses){
                System.out.println("\nYou lost");
                System.out.println("the word to find was: " + wordToGuess);
                //added force exit on loss here because of the random word library
                // im using doesn't close the http connection when generating word for some reason
                System.exit(0);
            }
        }
        catch (Exception e){
            throw new NullPointerException("");
        }

    }

    //call before start to ensure everything is set to 0
    public void newGame(){
        wordToGuess = generatedWord.generateNewWord();
        wrongGuesses = 0;
        playerGuessedLetters.clear();
        lettersFoundInWord = new char[wordToGuess.length()];

        for(int i = 0; i < wordToGuess.length(); i++){
            lettersFoundInWord[i] = '_';
        }
    }

    //game check to see if what the player has guessed equals the generated word
    public boolean wordFound(){
        return wordToGuess.contentEquals(new String(lettersFoundInWord));
    }

    //Method to make the displaying of '_' neater by first adding them to a string then adding a space afterwards
    private String randomWordBuilder(){
        StringBuilder wordBuilder = new StringBuilder();

        for(int i = 0; i < wordToGuess.length(); i++){
            wordBuilder.append(lettersFoundInWord[i]);

            if(i < wordToGuess.length() - 1){
                wordBuilder.append(" ");
            }
        }
        return wordBuilder.toString();
    }

    private void updateLettersInWord(String letter){
        //check if player already guessed that letter
        if(!playerGuessedLetters.contains(letter)){

            //check if generated word has the letter
            if(wordToGuess.contains(letter)){
                int index = wordToGuess.indexOf(letter);

                while(index >= 0){
                    //finding where in the random word the guessed letter goes
                    lettersFoundInWord[index] = letter.charAt(0);

                    //move on to the next letter in generated word
                    index = wordToGuess.indexOf(letter, index + 1);
                }
            }
            else{
                //if letter is not in the generated word add a wrong guess to the count
                wrongGuesses++;
                //add a body part to the man
                drawTool.updateMan(board);
            }
            //add letter to player guesses
            playerGuessedLetters.add(letter);
        }
    }
}
