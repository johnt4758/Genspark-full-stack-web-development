package genspark.john_manuel;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        Land land = new Land();
        Human human = new Human();
        Goblin goblin = new Goblin();

        //Opening Lines, Explaining the rules of the game
        System.out.println("Welcome to Human Vs Goblin. The objective of the game is to... survive!");
        System.out.println("There are Goblins hidden within the board. Move around to gain points");
        System.out.println("Game over when you die. (Note: one Goblin fight won't kill you)");
        System.out.println("Controls: move with WASD");

        land.updateBoard(0, 0, human);
        System.out.println(land.toString());
    }
}
