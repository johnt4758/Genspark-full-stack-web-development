package genspark.john_manuel;

import java.util.Random;

public class Goblin extends Humanoid{

    private int health = 10;
    private int strength = 5;
    private Random ranNum = new Random();

    public Goblin(){
        super.setHealth(health);
        super.setStrength(strength);

        startingPosition();
    }

    public void startingPosition(){
        super.setX_pos(ranNum.nextInt(10) - 1);
        super.setY_pos(ranNum.nextInt(10) - 1);
    }

    public String conceal(){
        return "*";
    }

    @Override
    public String toString(){return "ç";}
}
