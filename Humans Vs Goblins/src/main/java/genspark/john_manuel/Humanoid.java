package genspark.john_manuel;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Humanoid {

    private int health;
    private int strength;
    private int x_pos;
    private int y_pos;

    private final Map<Integer, Integer> cords = new TreeMap<>();
    private final Map<Integer, Integer> currentCords = new TreeMap<>();

    //Getters
    public int getHealth(){return health;}
    public int getStrength(){return strength;}
    public int getX_pos(){return x_pos;}
    public int getY_pos() {return y_pos;}

    public Map<Integer, Integer> getCords(){return cords;}
    public Map<Integer, Integer> getCurrentCords(){return currentCords;}

    //Setters
    public void setHealth( int newHealth){health = newHealth;}
    public void setStrength(int newStrength){strength = newStrength;}
    public void setX_pos(int newX_pos){x_pos = newX_pos;}
    public void setY_pos(int newY_pos){y_pos = newY_pos;}

    public void setCurrentCords(int x, int y){currentCords.clear(); currentCords.put(x, y);}

    public void addCords(int x, int y){cords.put(x, y);}

}
