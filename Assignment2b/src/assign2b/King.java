/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign2b;

import java.awt.Color;

/**
 * King – can move in any direction 1 space
 * @author Jing
 */
public class King extends Piece{

    /**
     * King Constructor
     * @param str "K"
     * @param color "Player's color"
     */
    public King(String str, Color color) {
        super("K", color);
    }
    
    
    boolean isValidMove(Square[][] squares, Square squareFrom, Square squareTo, Color player){
        int i1 = squareFrom.i;
        int i2 = squareTo.i;
        int j1 = squareFrom.j;
        int j2 = squareTo.j;
        boolean result = false;
        if ((squareFrom.getPiece().getColor().equals(player) && !squareTo.getPiece().getColor().equals(player))) {
            if (Math.abs(i2 - i1) == 1 && (j2 - j1) == 0) {
                result = true;
            } else if ((i2 - i1) == 0 && Math.abs(j2 - j1) == 1) {
                result = true;
            } else if (Math.abs(i2 - i1) == 1 && Math.abs(j2 - j1) == 1) {
                result = true;
            } else {
                result = false;
            }
        }else{
            result = false;
        }      

        return result;
    }

}
