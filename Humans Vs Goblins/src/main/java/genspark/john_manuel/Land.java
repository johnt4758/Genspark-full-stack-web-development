package genspark.john_manuel;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Land {

    //constant board size
    private static final int HEIGHT_Y = 10;
    private static final int HEIGHT_X = 10;

    //2D array for ease of storing and reading board
    private String[][] land;

    //board constructor looping through rows and columns and placing # as the ground
    public Land(){
        land = new String[HEIGHT_X][HEIGHT_Y];
        for(int x = 0; x < HEIGHT_X; x++){
            for(int y = 0; y < HEIGHT_Y; y++){
                land[x][y] = "*";
            }
        }
    }

    //called to place an object onto the board
    public void updateBoard(int new_x, int new_y, Object obj){
        for(int x = 0; x < HEIGHT_X; x++){
            for(int y = 0; y < HEIGHT_Y; y++){
                if(x == new_x && y == new_y){
                    //check if obj passed is a goblin, if it is then conceal it by replacing the representation of goblin with the basic board piece
                    if(obj instanceof Goblin){
                        land[x][y] = ((Goblin) obj).toString();
                        ((Goblin) obj).setX_pos(x);
                        ((Goblin) obj).setY_pos(y);
                    }else if(obj instanceof Human){
                        land[x][y] = ((Human) obj).toString();
                        ((Human) obj).setX_pos(x);
                        ((Human) obj).setY_pos(y);
                    }
                }
            }
        }
    }

    public void startingBoard(Object obj){
        for(int x = 0; x < HEIGHT_X; x++){
            for(int y = 0; y < HEIGHT_Y; y++){
                if(obj instanceof Goblin || obj instanceof Human){
                    if(x == ((Humanoid) obj).getX_pos() && y == ((Humanoid) obj).getY_pos()){
                        land[x][y] = obj.toString();
                    }
                }
            }
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
