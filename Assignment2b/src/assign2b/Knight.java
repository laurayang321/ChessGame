/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign2b;

import java.awt.Color;

/**
 * Knight – moves in an “L” pattern of 2-1 or 1-2 in any direction, 
 * the path does not need to be clear.
 * @author Jing
 */
public class Knight extends Piece{

    /**
     * Knight Constructor
     * @param str "N"
     * @param color "player's color"
     */
    public Knight(String str, Color color) {
        super("N", color);
    }
    
    @Override
    boolean isValidMove(Square[][] squares, Square squareFrom, Square squareTo, Color player){
        int i1 = squareFrom.i;
        int i2 = squareTo.i;
        int j1 = squareFrom.j;
        int j2 = squareTo.j;
        if ((squareFrom.getPiece().getColor().equals(player)&& !squareTo.getPiece().getColor().equals(player))) {
            if (((i1 - i2) == 1 && (j1 - j2) == 2) || ((i1 - i2) == -1 && (j1 - j2) == 2) || ((i1 - i2) == -1 && (j1 - j2) == -2) || ((i1 - i2) == 1 && (j1 - j2) == -2)
                    || ((i1 - i2) == 2 && (j1 - j2) == 1) || ((i1 - i2) == -2 && (j1 - j2) == 1) || ((i1 - i2) == -2 && (j1 - j2) == -1) || ((i1 - i2) == 2 && (j1 - j2) == -1)) {
                return true;
            } else {
                System.out.println("i1 - i2 = " + (i1 - i2));
                System.out.println("j1 - j2 = " + (j1 - j2));
                System.out.println("valid move!");
                return false;
            }
        }else{
            return false;
        }
    }
}
