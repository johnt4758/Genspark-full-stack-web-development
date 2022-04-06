package genspark.john_manuel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Land {

    //constant board size
    private static final int HEIGHT_Y = 10;
    private static final int WIDTH_X = 10;

    //2D array for ease of storing and reading board
    private final String[][] land;

    //Random number for amount of goblins on board
    private final Random random = new Random();
    private final int randomNum = random.nextInt(6) + 1;

    //List containing all the generated goblins
    private final ArrayList<Goblin> goblins = new ArrayList<>();

    //board constructor looping through rows and columns and placing * as the ground
    public Land(){
        generateGoblins();

        land = new String[WIDTH_X][HEIGHT_Y];
        for(int x = 0; x < land.length; x++){
            for(int y = 0; y < land[x].length; y++){
                land[x][y] = "*";
            }
        }
    }

    //creating random number of goblins to fight on the board
    public void generateGoblins(){
        for(int g = 0; g < randomNum; g++){
            Goblin goblin = new Goblin();
            goblins.add(g, goblin);
        }
    }

    //called to place an object onto the board
    public void updateBoard(int new_x, int new_y, Human human){
        //add the cords for the object to its list of places been
        human.addCords(new_x, new_y);

        //Loop through board to update objects place on it
        for(int x = 0; x < land.length; x++){
            for(int y = 0; y < land[x].length; y++){
                if(human.getCurrentCords().containsKey(x) && human.getCurrentCords().containsValue(y)){
                    land[x][y] = " ";
                }
                if(x == new_x && y == new_y){
                    land[x][y] = human.toString();
                    human.setCurrentCords(x, y);
                }
            }
        }
    }

    public void startingBoard(Human human){
        for(int x = 0; x < land.length; x++){
            for(int y = 0; y < land[x].length; y++){
                if(human.getCurrentCords().containsKey(x) && human.getCurrentCords().containsValue(y)){
                    land[x][y] = human.toString();
                    human.addCords(x, y);
                    human.setCurrentCords(x, y);
                }
                try{
                    //for each goblin in the goblin list get its current cords (which are generated on goblin creation)
                    //place goblin on starting board
                    for (Goblin goblin : goblins) {
                        if (goblin.getCurrentCords().containsKey(x) && goblin.getCurrentCords().containsValue(y)) {
                            land[x][y] = goblin.toString();
                        }
                    }
                }
                catch (IndexOutOfBoundsException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void checkPosition(int row, int column){

    }

    public void combat(Human human, Goblin goblin){
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        int whoHits = (int)(Math.random() * range) + min;

        while (goblin.getHealth() > 0 || human.getHealth() > 0){
            if(whoHits % 2 == 0){
                goblin.setHealth(goblin.getHealth() - human.getStrength());
            }
            else {
                human.setHealth(human.getHealth() - goblin.getStrength());
            }
        }
        if(human.getHealth() <= 0){
            System.out.println("You have died");
            System.exit(0);
        }
    }

    @Override
    public String toString(){
        return Arrays.deepToString(land).replace("], ", "]\n")
                                        .replace(", ", " ")
                                        .replace("]]", "]")
                                        .replace("[[", "[");
    }
}
