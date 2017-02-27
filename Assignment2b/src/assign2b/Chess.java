/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign2b;
import javax.swing.JFrame;
/**
 * Chess class creates a chess board and contain a method to display it. 
 * @author Jing
 */
public class Chess {

    /**
     * Create a board object and display it. 
     */
    public void displayChess(){
        final Board frame = new Board();

        frame.pack();

        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
