package assign2b;

import java.awt.Color;

/**
 * pawn – can move forward 1 or 2 on that piece’s FIRST move, 
 * 1 forward afterwards. 
 * @author Jing
 */
public class Pawn extends Piece{
    int flag = 0;

    /**
     * Pawn constructor
     * @param str "P"
     * @param color player's color
     */
    public Pawn(String str, Color color) {
        super(str, color);
    }
    
    boolean isValidMove(Square[][] squares, Square squareFrom, Square squareTo, Color player){
        int i1 = squareFrom.i;
        int i2 = squareTo.i;
        int j1 = squareFrom.j;
        int j2 = squareTo.j;
        boolean result = false;
        if (squares[i2][j2].hasPiece() == true) {
            System.out.println("squares[" + i2 + "][" + j2 + "].hasPiece() == true");
        } else {
            System.out.println("squares[" + i2 + "][" + j2 + "].hasPiece() == false");
        }
        if (player.equals(Color.red)) {
            if (flag == 0) {
                if (j2 - j1 == 0 && ((i2 - i1) == -2 || (i2 - i1) == -1)) {
                    result = true;
                    flag = 1;
                    return result;
                }
            }else{
                if( j2-j1 == 0 && (i2-i1) == -1 ){
                    result = true;
                    flag = 1;
                    return result;
                }
            }
        }else{
           if(flag == 0){
                if( j2-j1 == 0 && ((i2-i1) == 2 || (i2-i1) == 1)  ){
                    result = true;
                    flag = 1;
                    return result;
                }
            }else{
                if( j2-j1 == 0 && (i2-i1) == 1 ){
                    result = true;
                    flag = 1;
                    return result;
                }
            }                                    
        }   
        
        
        return result;
        /*
        if( ((i1-i2) == 1 && (j1-j2) == 2) || ((i1-i2) == -1 && (j1-j2) == 2) || ((i1-i2) == -1 && (j1-j2) == -2) || ((i1-i2) == 1 && (j1-j2) == -2) 
                || ((i1-i2) == 2 && (j1-j2) == 1) || ((i1-i2) == -2 && (j1-j2) == 1) || ((i1-i2) == -2 && (j1-j2) == -1) || ((i1-i2) == 2 && (j1-j2) == -1)){
            if( (squareFrom.getPiece().getColor() == player && squareTo.getPiece().getColor() != player ) ){
                result = true;
            }
        }else{    
            System.out.println("i1 - i2 = " + (i1-i2) );
            System.out.println("j1 - j2 = " + (j1-j2) );           
            System.out.println("valid move!");
            result = false;
        }    
        return result;
      */ 
    }
    
}
