package MAIN;

import java.awt.Dimension;
import javax.swing.JFrame;
import MOD.*;

public class Game{

    /**
     * This method set the board up for the game.
     * @param args
     */
    public static void main(String[] args){
        Board board = new Board();
        board.setPreferredSize(new Dimension(500,500)); //need to use this instead of setSize
        board.setLocation(500, 250);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.pack();
        board.setVisible(true);
    }
}