package genspark.john_manuel;

import java.util.Scanner;

public class Human extends Humanoid{

    private int health = 20;
    private int strength = 5;

    public Human(){
        super.setHealth(health);
        super.setStrength(strength);

        startingPosition();
    }

    public void startingPosition(){
        super.setX_pos(0);
        super.setY_pos(0);
    }

    @Override
    public String toString(){return "ß";}
}
