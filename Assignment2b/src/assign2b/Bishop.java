package assign2b;

import java.awt.Color;

/**
 * Bishop – can move on the diagonal unlimited number of spaces as 
 * long as the way is clear of other pieces
 * @author Jing
 */
public class Bishop extends Piece{

    /**
     * Bishop Constructor
     * @param str "B"
     * @param color "player's color"
     */
    public Bishop(String str, Color color) {
        super("B", color);
    }
    
    
    @Override
    boolean isValidMove(Square[][] squares, Square squareFrom, Square squareTo, Color player){
        int i1 = squareFrom.i;
        int i2 = squareTo.i;
        int j1 = squareFrom.j;
        int j2 = squareTo.j;
        boolean result = false;
        int i, j;
        if ((squareFrom.getPiece().getColor().equals(player) && !squareTo.getPiece().getColor().equals(player))) {
            if( Math.abs(i2-i1) == Math.abs(j2-j1)){
                if( i2>i1 && j2>j1 ){
                    for( i=(i1+1), j=(j1+1); i<i2; i++, j++ ){
                        if( squares[i][j].hasPiece == true){
                            return false;
                        }
                    }
                    return true;
                }else if( i2<i1 && j2>j1 ){
                    for( i=(i2+1), j=(j1+1); i<i1; i++, j++ ){
                        System.out.println("squares[" + i + "][" + j + "] " + " hasPiece " + squares[i][j].hasPiece);
                        if( squares[i][j].hasPiece == true){
                            return false;
                        }
                    }
                    return true;
                }else if( i2>i1 && j2<j1 ){
                    for( i=(i1+1), j=(j2+1); i<i2; i++, j++ ){
                        if( squares[i][j].hasPiece == true){
                            return false;
                        }
                    }
                    return true;
                }else{
                    for( i=(i2+1), j=(j2+1); i<i1; i++, j++ ){
                        if( squares[i][j].hasPiece == true){
                            return false;
                        }
                    }
                    return true;
                }
            }else{
                return false;
            }
        }else{
            System.out.println("get my piece, put not my piece");
            return false;
        }  
        //return false;
        
    }
}
