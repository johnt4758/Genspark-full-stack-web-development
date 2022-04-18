package genspark.john_manuel;

import genspark.john_manuel.entities.Goblin;
import genspark.john_manuel.entities.Human;

import java.util.*;

public class Land {

    //constant board size
    private static final int HEIGHT_Y = 10;
    private static final int WIDTH_X = 10;

    //2D array for ease of storing and reading board
    private final Object[][] land;

    //Random number for amount of goblins on board
    private final Random random = new Random();
    private final int randomNum = random.nextInt(6) + 1;

    //List containing all the generated goblins
    private final ArrayList<Goblin> goblins = new ArrayList<>();

    private Human human = new Human();

    public boolean isAlive = true;

    //board constructor looping through rows and columns and placing * as the ground
    public Land(){
        generateGoblins();

        land = new Object[WIDTH_X][HEIGHT_Y];
        for(int x = 0; x < land.length; x++){
            for(int y = 0; y < land[x].length; y++){
                land[x][y] = "*";
            }
        }

        startingBoard();
    }

    //creating random number of goblins to fight on the board
    public void generateGoblins(){
        for(int g = 0; g < randomNum; g++){
            Goblin goblin = new Goblin();
            goblins.add(g, goblin);
        }
    }

    //called to move the player on the board
    public void updateBoard(int new_x, int new_y){
        //add the cords for the human to its list of places been
        human.addCords(new_x, new_y);

        //Loop through board to update humans place on it
        for(int x = 0; x < land.length; x++){
            for(int y = 0; y < land[x].length; y++){
                //before changing current position, replace the soon-to-be old cords with just a space
                //indicating the player has been there already
                if(human.getCurrentCords().containsKey(x) && human.getCurrentCords().containsValue(y)){
                    land[x][y] = " ";
                }
                //update current cords to newly inputted cords
                if(x == new_x && y == new_y){
                    land[x][y] = human;
                    human.setCurrentCords(x, y);
                }
            }
        }
        checkPosition(new_x, new_y, human);
    }

    public void startingBoard(){
        for(int x = 0; x < land.length; x++){
            for(int y = 0; y < land[x].length; y++){
                if(human.getCurrentCords().containsKey(x) && human.getCurrentCords().containsValue(y)){
                    land[x][y] = human;
                    human.addCords(x, y);
                    human.setCurrentCords(x, y);
                }
                try{
                    //for each goblin in the goblin list get its current cords (which are generated on goblin creation)
                    //place goblin on starting board
                    for (Goblin goblin : goblins) {
                        if (goblin.getCurrentCords().containsKey(x) && goblin.getCurrentCords().containsValue(y)) {
                            land[x][y] = goblin;
                        }
                    }
                }
                catch (IndexOutOfBoundsException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void checkPosition(int row, int column, Human human){
        //check if human cords +/- 1 equals a goblin object
        if(land[row][column] instanceof Human){
            System.out.println("found human");
            try{
                Object up = land[row-1][column];
                Object down = land[row+1][column];
                Object right = land[row][column+1];
                Object left = land[row][column-1];

                if(up instanceof Goblin){
                    land[row-1][column] = ((Goblin) up).reveal();
                    combat(human, (Goblin) (up));
                }
                if(down instanceof Goblin){
                    land[row+1][column] = ((Goblin) down).reveal();
                    combat(human, (Goblin) (down));
                }
                if(left instanceof Goblin){
                    land[row][column-1] = ((Goblin) left).reveal();
                    combat(human, (Goblin) (left));
                }
                if(right instanceof Goblin){
                    land[row][column+1] = ((Goblin) right).reveal();
                    combat(human, (Goblin) (right));
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println("null");
            }
        }
    }

    public boolean combat(Human human, Goblin goblin){
        int max = 10;
        int min = 1;
        int range = max - min + 1;

        System.out.println("Combat has started!");

        isAlive = true;

        while (isAlive){
            int whoHits = (int)(Math.random() * range) + min;

            if(whoHits % 2 == 0){
                goblin.setHealth(goblin.getHealth() - human.getStrength());
                if(goblin.getHealth() <= 0){
                    break;
                }
            }
            else {
                human.setHealth(human.getHealth() - goblin.getStrength());
                if(human.getHealth() <= 0){
                    System.out.println("You have died");
                    isAlive = false;
                }
            }
        }
        return isAlive;
    }

    @Override
    public String toString(){
        return Arrays.deepToString(land).replace("], ", "]\n")
                                        .replace(", ", " ")
                                        .replace("]]", "]")
                                        .replace("[[", "[");
    }
}
