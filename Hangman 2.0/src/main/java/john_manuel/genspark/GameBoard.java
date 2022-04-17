package john_manuel.genspark;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class GameBoard {

    private final Path hangmanImagePath = Paths.get("john_manuel/genspark/art","hangmanArt.json");


    public void getBoard(){
        try(Stream<String> fileContents = Files.lines(hangmanImagePath)){
            fileContents.forEach(System.out::println);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateBoard(){
        try {
            Scanner fileReader = new Scanner(System.in);
            //loop through file for each line with java stream function
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
