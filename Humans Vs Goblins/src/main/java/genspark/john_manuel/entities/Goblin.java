package genspark.john_manuel.entities;

import java.util.Random;

public class Goblin extends Humanoid {

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
        //check if starting position of goblin would be any combination of 1
        //changing it to 2 so there's no immediate combat for player
        if(randomInt == 1){
            randomInt++;
        }
        super.setCurrentCords(randomInt, randomInt);
    }

    public String reveal(){
        return "ç";
    }

    @Override
    public String toString(){return "C";}
}
