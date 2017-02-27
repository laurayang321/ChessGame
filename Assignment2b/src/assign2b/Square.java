package assign2b;

import java.awt.Color;
import javax.swing.JPanel;

/**
 * Square class that reflects the square on a chess game
 * @author Jing
 */
public class Square extends JPanel{
    Piece piece;
    boolean hasPiece = false;
    int i;
    int j;

    /**
     * Square constructor
     * @param i the vertical index of that square
     * @param j the horizontal index of that square
     */
    public Square(int i, int j){
        this.i = i;
        this.j = j;                              
        if(i==1){
             piece=new Pawn("P", Color.blue);
             hasPiece = true;
         }else if(i==6){
             piece=new Pawn("P", Color.red);
             hasPiece = true;
         }else if(i==0 && (j==0 || j==7)){
             piece=new Rook("R", Color.blue);
             hasPiece = true;
         }else if(i==7 && (j==0 || j==7)){
             piece=new Rook("R", Color.red);
             hasPiece = true;
         }else if(i==0 && (j==1 || j==6)){
             piece=new Bishop("B", Color.blue);
             hasPiece = true;
         }else if(i==7 && (j==1 || j==6)){
             piece=new Bishop("B", Color.red);
             hasPiece = true;
         }else if(i==0 && (j==2 || j==5)){
             piece=new Knight("N", Color.blue);
             hasPiece = true;
         }else if(i==7 && (j==2 || j==5)){
             piece=new Knight("N", Color.red);
             hasPiece = true;
         }else if(i==0 && j==3 ){
             piece=new King("K", Color.blue);
             hasPiece = true;
         }else if(i==7 && j==3){
             piece=new King("K", Color.red);
             hasPiece = true;
         }else if(i==0 && j==4){
             piece=new Queen("Q", Color.blue);
             hasPiece = true;
         }else if(i==7 && j==4){
             piece=new Queen("Q", Color.red);
             hasPiece = true;
         }else{
             piece=new Empty("", Color.green);
             hasPiece = false;
         }       
        
        add(piece);

    }

    /**
     * return the piece on that square
     * @return
     *      return the piece on that square
     */
    public Piece getPiece(){        
        return this.piece;
    }
    
    /**
     * return if the square has a piece on it
     * @return
     *      return the if the piece has piece
     */
    public boolean hasPiece(){
        return this.hasPiece;
    }
    
    /**
     * put a piece on that square 
     * @param piece
     *      the piece that user wants to put on it 
     */
    public void setPiece(Piece piece){
        this.piece = piece;
        add(piece);
        if(piece.getName() == ""){
            this.hasPiece = false;
        }else{
            this.hasPiece = true;
        }
        
    }
    
    /**
     * remove the piece on that square
     */
    public void removePiece(){
        this.piece.setForeground(Color.green);
        this.piece.setText("");
        this.piece.setName("");
        this.piece.setColor(Color.green);
        this.hasPiece = false;
        
    }
    
    /**
     * set the hasPiece value on that square to reflect if it has a 
     * piece on it
     * @param hasPiece
     *      the boolean value that reflect if the square has a piece
     */
    public void setHasPiece(boolean hasPiece){
        this.hasPiece = hasPiece;
    }
    
}
