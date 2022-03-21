package genspark.John_Manuel;

import java.util.Scanner;

public class Guess {

    public int minNum = 1;
    public int maxNum = 20;
    public int tries = 6;

    public String playerName;
    public String playerResponse;

    public String onStart(){

        //on launch greeting
        System.out.println("Hello! Welcome to my guessing game!");
        System.out.println("to get started; what is your name?");

        try {
            playerName  = new Scanner(System.in).nextLine();

            //saying hello to user
            System.out.println("well, " + playerName + ", I am thinking of a number between 1 and 20");
            System.out.println("take a guess");
        }
        catch (Exception e) {
            System.out.println("Please enter your name");
        }
        return playerName;
    }

    public void numberGuessing(String userName){
        //getting random number, making sure it's at least 1
        int randomNumber = (int) (Math.random() * (maxNum - minNum) + minNum);

        //start the looping with the outer layer being the attempts
        for (int i = 0; i <= tries; i++) {
            try {
                int playerGuess = new Scanner(System.in).nextInt();
                //starting checks for what the player guessed vs the number generated
                if (randomNumber > playerGuess && i != tries - 1) {
                    System.out.println("Try guessing higher");
                }
                else if (randomNumber < playerGuess && i != tries - 1) {
                    System.out.println("Try guessing lower");
                }
                else if (randomNumber == playerGuess) {
                    System.out.println("Good job, " + userName + "! You guessed my number in " + i + " guesses!");
                    break;
                }
                if (i == tries) {
                    System.out.println("Sorry " + playerName + ", you ran out of attempts");
                    System.out.println("the number I was thinking of was " + randomNumber);
                    break;
                }
            }
            catch (Exception e){
                System.out.println("Please guess a number");
            }
        }
    }

    public void runGame( String userName) {
        numberGuessing(userName);
        System.out.println("would you like to play again? (y or n)");
        try {
            playerResponse = new Scanner(System.in).nextLine();
            if (playerResponse.equals("n")){
                System.out.println("Sad to see you go :( ");
            }
            else if (playerResponse.equals("y")) {
                System.out.println("restarting...");
                System.out.println("gotcha! not implemented yet");
            }
        }
        catch (Exception e2){
            System.out.println("Input wasn't a 'y' or 'n'");
        }
    }
}
