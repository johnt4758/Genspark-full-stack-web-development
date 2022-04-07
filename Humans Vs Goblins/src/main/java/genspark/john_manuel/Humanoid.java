package genspark.john_manuel;

import java.util.Map;
import java.util.TreeMap;

public class Humanoid {

    private int health;
    private int strength;

    private final Map<Integer, Integer> cords = new TreeMap<>();
    private final Map<Integer, Integer> currentCords = new TreeMap<>();

    //Getters
    public int getHealth(){return health;}
    public int getStrength(){return strength;}

    public Map<Integer, Integer> getCords(){return cords;}
    public Map<Integer, Integer> getCurrentCords(){return currentCords;}

    //Setters
    public void setHealth( int newHealth){health = newHealth;}
    public void setStrength(int newStrength){strength = newStrength;}

    public void setCurrentCords(int x, int y){currentCords.clear(); currentCords.put(x, y);}

    //Adders (specifically for clarification when adding cords)
    public void addCords(int x, int y){cords.put(x, y);}

}
