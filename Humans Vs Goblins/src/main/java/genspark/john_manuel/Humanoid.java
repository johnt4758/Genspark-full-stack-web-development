package genspark.john_manuel;

public class Humanoid {

    private int health;
    private int strength;
    private int x_pos;
    private int y_pos;

    private int[] position;

    public int getHealth(){return health;}
    public int getStrength(){return strength;}
    public int getX_pos(){return x_pos;}
    public int getY_pos() {return y_pos;}

    public int[] getPosition() {return position;}

    public void setHealth( int newHealth){health = newHealth;}
    public void setStrength(int newStrength){strength = newStrength;}
    public void setX_pos(int newX_pos){x_pos = newX_pos;}
    public void setY_pos(int newY_pos){y_pos = newY_pos;}

    public void setPosition(){position[0] = getX_pos(); position[1] = getY_pos();}


    void attack(){}

    //potentially move either entity here
    void move(){}
}
