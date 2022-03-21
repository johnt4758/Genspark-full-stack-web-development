package genspark.john_manuel;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class App 
{
    //Added in try blocks for user input for project 3
    public static void main( String[] args )
    {
        //Opening lines for the dragon's cave project
        //these lines can also be added to its own method for cleaner looking code
        System.out.println( "You find yourself suddenly in world full of dragons" );
        System.out.println("You see two caves. In one cave, the dragon is friendly");
        System.out.println("he will share his treasure with you. The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you choose? (1 or 2)");

        try
        {
           int userInput = getUserInput();
           System.out.println(userInput + " huh?");

           //using basic if statements to determine what the user wrote in the console
           //appropriate responses follow
           if (userInput == 1)
           {
               System.out.println("You approach the cave slowly...");
               System.out.println("It's dark and spooky...");
               System.out.println("A large dragon  jumps out in front of you! His jaws open and...");
               System.out.println("Gobbles you down in one bite!");
           }
           if (userInput == 2) {
               System.out.println("The dragon looks to you and says...");
               System.out.println("oh yea, that other dragons lies to get people into his cave to eat them");
           }
        }
        catch (Exception e)
        {
            System.out.println("Please Choose a valid option of 1 or 2");
        }
    }

    public static @NotNull Integer getUserInput()
    {
        Scanner userScanner = new Scanner(System.in);

        return userScanner.nextInt();
    }
}
