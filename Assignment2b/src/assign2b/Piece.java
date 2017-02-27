package assign2b;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;

/**
 * Piece class is the piece on the square of the chess board
 * @author Jing
 */
public class Piece extends JLabel {
    String name;    
    Color color;


    /**
     * Piece constructor.
     * @param str
     *      the text on the piece. 
     * @param color
     *      the text color on the piece.
     */
    public Piece(String str, Color color){
        super();
        this.setText(str);
        name=str;
        this.color = color;
        this.setFont(new Font("Calibri", Font.BOLD, 32));
        this.setForeground(color);
        this.setPreferredSize(new Dimension(100,100));
    }
    
    /**
     * return the text color on the piece. 
     * @return
     *      text color on the piece
     */
    public Color getColor(){
        return this.color;
    }
    
    /**
     * set the piece's local variable color to its changes color.
     * @param color1
     */
    public void setColor(Color color1){
        color = color1;
    }
    @Override
    public void setName(String n){
        name=n;
    }

    @Override
    public String getName(){
        return name;
    }
    
    boolean isValidMove(Square[][] squares, Square squareFrom, Square squareTo, Color player){
        return false;        
    }
    
}
