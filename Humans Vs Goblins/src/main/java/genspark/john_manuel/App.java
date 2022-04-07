package genspark.john_manuel;

import java.util.Arrays;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Land land = new Land();

        start();

        System.out.println(land);

        try{
            Scanner userInput = new Scanner(System.in);
            while(land.isAlive){
                String  input = userInput.next();
                String[] nums = input.split(",");

                land.updateBoard(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));

                System.out.println("\n" + land);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void start(){
        //Opening Lines, Explaining the rules of the game
        System.out.println("\nWelcome to Human Vs Goblin. The objective of the game is to... survive!");
        System.out.println("There are Goblins hidden within the board. Move around to clear out the whole board");
        System.out.println("Game over when you die or clear whole board. (Note: one Goblin fight won't kill you)");
        System.out.println("Controls: move by inputting 2 numbers between 0-9 separated by a comma\n");
    }
}
