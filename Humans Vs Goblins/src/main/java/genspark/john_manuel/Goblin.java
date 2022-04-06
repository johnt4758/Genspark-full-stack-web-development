package genspark.john_manuel;

import java.util.Random;

public class Goblin extends Humanoid{

    //Using random to get random number for starting location of goblin
    private final Random ranNum = new Random();

    public Goblin(){
        int health = 10;
        int strength = 5;

        super.setHealth(health);
        super.setStrength(strength);

        startingPosition();
    }

    public void startingPosition(){
        int randomInt = ranNum.nextInt(9) + 1;
        super.setCurrentCords(randomInt, randomInt);
    }

    public String reveal(){
        return "*";
    }

    @Override
    public String toString(){return "ç";}
}
