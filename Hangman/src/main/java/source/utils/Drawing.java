package source.utils;

import java.util.ArrayList;

public class Drawing {

    public StringBuilder boardDrawing(){
        StringBuilder board = new StringBuilder();
            board.append("+-----+");
            board.append("\n      |");
            board.append("\n      |");
            board.append("\n      |");
            board.append("\n      |");
            board.append("\n   =======");
        return board;
    }

    public StringBuilder updateMan(StringBuilder builder){
        //lots of if statements to check which part of body is already drawn
        if(builder.charAt(8) == ' '){
            builder.replace(8,9, "O");
        }
        else if(builder.charAt(16) == ' '){
            builder.replace(16,17, "|");
        }
        else if(builder.charAt(24) == ' '){
            builder.replace(24, 25, "|");
        }
        else if(builder.charAt(32) == ' '){
            builder.replace(32, 33, "^");
        }
        return builder;
    }

    public void displayBoard(StringBuilder builder){
        System.out.println(builder.toString());
    }
}

