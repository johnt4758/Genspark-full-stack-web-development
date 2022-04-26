package genspark.john_manuel;

import genspark.john_manuel.entities.Goblin;
import genspark.john_manuel.entities.Human;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Random;

public class GameGUI {

    //constant board size
    private static final int HEIGHT_Y = 10;
    private static final int WIDTH_X = 10;

    //Random number for amount of goblins on board
    private final Random random = new Random();

    private final int randomNum = random.nextInt(6) + 1;

    //List containing all the generated goblins
    private final ArrayList<Goblin> goblins = new ArrayList<>();

    private final Human human = new Human();

    public boolean isAlive = true;

    private JTable gameBoard;
    public JPanel panel1;
    private JLabel healthLabel;
    private JLabel healthValue;

    public GameGUI(){
        healthLabel.setText("Health");
        healthValue.setText(String.valueOf(human.getHealth()));

        DefaultTableModel tableModel = new DefaultTableModel();

        for(int i = 0; i < 10; i++){
            tableModel.addColumn(i + 1);
            tableModel.addRow(new Object[]{"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"});
        }

        gameBoard.setModel(tableModel);
    }

    //creating random number of goblins to fight on the board
    public void generateGoblins(){
        for(int g = 0; g < randomNum; g++){
            Goblin goblin = new Goblin();
            goblins.add(g, goblin);
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
}
