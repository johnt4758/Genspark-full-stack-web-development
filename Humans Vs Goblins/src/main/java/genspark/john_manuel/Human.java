package genspark.john_manuel;

public class Human extends Humanoid{

    public Human(){
        int health = 40;
        int strength = 5;

        super.setHealth(health);
        super.setStrength(strength);

        startingPosition();
    }

    public void startingPosition(){
        super.setCurrentCords(0, 0);
    }

    @Override
    public String toString(){return "ß";}
}
