package assign2b;

import java.awt.Color;

/**
 * Empty class that creates an empty piece
 * @author Jing
 */
public class Empty extends Piece{

    /**
     * Empty piece that has empty name and green color
     * @param str
     * @param color
     */
    public Empty(String str, Color color) {
        super("", Color.green);
    }
    
    boolean isValidMove(Square[][] squares, Square squareFrom, Square squareTo, Color player){
        return true;        
    }
}
