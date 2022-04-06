package genspark.john_manuel;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        Land land = new Land();
        Human human = new Human();

        start();

        land.startingBoard(human);

        System.out.println(land.toString());

        land.updateBoard(4, 5, human);

        System.out.println("\n" + land.toString());

        System.out.println("\nHuman's cords: " + human.getCords());
        System.out.println("Human Current cords: " + human.getCurrentCords());
    }

    public static void start(){
        //Opening Lines, Explaining the rules of the game
        System.out.println("\nWelcome to Human Vs Goblin. The objective of the game is to... survive!");
        System.out.println("There are Goblins hidden within the board. Move around to clear out the whole board");
        System.out.println("Game over when you die or clear whole board. (Note: one Goblin fight won't kill you)");
        System.out.println("Controls: move by inputting 2 numbers between 0-9 separated by a space\n");
    }
}
