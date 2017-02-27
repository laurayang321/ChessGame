/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign2b;

import java.awt.Color;

/**
 * Rook – can move horizontal or vertical unlimited number of 
 * spaces as long as the way is clear of other pieces
 * @author Jing
 */
public class Rook extends Piece{

    /**
     * Rook constructor
     * @param str "R" 
     * @param color player's color on the rook piece
     */
    public Rook(String str, Color color) {
        super("R", color);
    }
    
    boolean isValidMove(Square[][] squares, Square squareFrom, Square squareTo, Color player){
        int i1 = squareFrom.i;
        int i2 = squareTo.i;
        int j1 = squareFrom.j;
        int j2 = squareTo.j;
        boolean result = false;
        int i, j;
        if ((squareFrom.getPiece().getColor().equals(player) && !squareTo.getPiece().getColor().equals(player))) {
            System.out.println("get my piece, put in not my piece");
            if (j2 - j1 == 0) {
                System.out.println("Vertical");
                if (i2 - i1 < 0) {
                    System.out.println("move up");
                    for( i = (i2+1); i < i1; i++ ){
                        if( squares[i][j1].hasPiece() == true ){
                            //System.out.println(i + " " + j1 + " ");
                            if( squares[i][j1].hasPiece() == true ){
                                System.out.println("squares[" + i + "][" + j1 + "].hasPiece() == true");
                            }else{
                                System.out.println("squares[" + i + "][" + j1 + "].hasPiece() == false");
                            }
                            return false;
                        }
                    }
                    return true;
                }else{
                     System.out.println("move down");
                    for( i = (i1+1); i < i2; i++ ){
                        if( squares[i][j1].hasPiece() == true ){
                            return false;
                        }
                    }
                    return true;
                }
            }else if( i2 - i1 == 0) {
                System.out.println("Horizontal");
                if( j2 - j1 < 0 ){
                    System.out.println("move left");
                    for( j = (j2+1); j < j1; j++ ){
                        if( squares[i1][j].hasPiece() == true ){
                            return false;
                        }
                    }
                    return true;
                }else{
                    System.out.println("move right");
                    for( j = (j1+1); j < j2; j++ ){
                        if( squares[i1][j].hasPiece() == true ){
                            return false;
                        }
                    }
                    return true;                    
                }
            }else{
                System.out.println("not vertical or horizontal");
                return false;
            }
        }else{
            System.out.println("get my piece, put not my piece");
            return false;
        }  
    }
}
