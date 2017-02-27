package assign2b;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Board class create a board object and initialize all the pieces on 
 * the chess board.User can use the chess board to play the chess game. 
 * @author Jing
 */
public class Board extends JFrame{
    static Piece tmpPiece;
    static boolean counthold = false;
    static Square tmpSquare;
    static Color tmpColor;
    static Square tmpSquares[][] = new Square[8][8];

    Color player = Color.green;
    Square squares[][];
    JFileChooser saveChooser = new JFileChooser();
    JFileChooser loadChooser = new JFileChooser();    

    /**
     * Board Constructor 
     */
    public Board(){
        setResizable(false);
        this.setBounds(100, 100, 800, 800);
        int count = 1;

        GridLayout layout = new GridLayout(8, 8);
        setTitle("Chess");
        setLayout(layout);
        
        final JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");                
        
        
        
        menuBar.add(file);
        file.add(save);
        file.add(load);
        setJMenuBar(menuBar);
        
        load.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(JFileChooser.APPROVE_OPTION == loadChooser.showOpenDialog(null) ){
                    // System.out.println(loadChooser.getSelectedFile().getAbsolutePath());
                   try {
                    //
                        FileInputStream fileIn = new FileInputStream(loadChooser.getSelectedFile().getAbsolutePath());
                        ObjectInputStream in = new ObjectInputStream(fileIn);
                        tmpSquares = (Square[][]) in.readObject();

                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                //squares[i][j].setPiece( tmpSquares[i][j].getPiece() ) ;
                                squares[i][j].remove(squares[i][j].getPiece());
                                squares[i][j].repaint();
                                squares[i][j].setPiece(tmpSquares[i][j].getPiece());
                                squares[i][j].setHasPiece(tmpSquares[i][j].hasPiece);
                                squares[i][j].validate();
                                /*
                                 if(tmpSquares[i][j].getPiece().getName() == ""){
                                 System.out.println("tmpSquares[" + i + "][" + j + "].getPiece().getName() == \"\"" );
                                 squares[i][j].setHasPiece(false);
                                 }else{
                                 System.out.println("tmpSquares[" + i + "][" + j + "].getPiece().getName() == have name" );
                                 squares[i][j].setHasPiece(true);
                                 }
                                 */
                                squares[i][j].setHasPiece(tmpSquares[i][j].hasPiece);
                                System.out.println(squares[i][j].getPiece().getClass());
                                if (player == Color.green) {
                                    System.out.println("green");
                                } else if (player == Color.blue) {
                                    System.out.println("blue");
                                } else {
                                    System.out.println("red");
                                }

                                System.out.print("tmpSquares: " + i + " " + j + " " + " Name: " + tmpSquares[i][j].getPiece().getName());
                                if (tmpSquares[i][j].hasPiece == true) {
                                    System.out.print(" hasPiece == true");
                                } else {
                                    System.out.print(" hasPiece == false");
                                }
                                System.out.println();

                                System.out.print("squares: " + i + " " + j + " " + " Name: " + squares[i][j].getPiece().getName());
                                if (squares[i][j].hasPiece == true) {
                                    System.out.print(" hasPiece == true");
                                } else {
                                    System.out.print(" hasPiece == false");
                                }
                                System.out.println();
                                System.out.println();
                                System.out.println();

                            }
                        }

                        in.close();
                        fileIn.close();
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }


        });
        
        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(JFileChooser.APPROVE_OPTION == saveChooser.showSaveDialog(null)){
                    //
                    System.out.println(saveChooser.getSelectedFile().getAbsolutePath());
                    try {
                        //
                        FileOutputStream fileOut = new FileOutputStream(saveChooser.getSelectedFile().getAbsolutePath());
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                tmpSquares[i][j] = new Square(i, j);
                                tmpSquares[i][j] = squares[i][j];
                            }
                        }
                        out.writeObject(tmpSquares);
                        System.out.println("Save Squares[][]");
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                System.out.println(i + " " + j + " " + " Name: " + tmpSquares[i][j].getPiece().getName());
                            }
                        }
                        out.close();
                        fileOut.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                //
        
            }
        });
        
        /*
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                final String celciusString;
                final double celcius;
                celciusString = celciusInput.getText();
                celcius = Double.parseDouble(celciusString);
                convert(celcius);

            }
        });
        */
        

        squares = new Square[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square tmp = new Square(i, j);
                squares[i][j] = tmp;
                tmp.addMouseListener(new MouseAdapter(){
                    @Override
                    // If user has held a piece on hand, count=1; otherwise, count=0;   
                    public void mouseClicked(MouseEvent e){
                        
                        System.out.println("squares: " + tmp.i + " " + tmp.j + tmp.piece.getName() + tmp.getPiece().getColor());
                        if(player.equals(Color.green)){
                            player = tmp.getPiece().getColor();
                        }
                        System.out.println(counthold );
                        System.out.println(player );
                        
                        if( tmp.hasPiece()  && tmp.piece.getColor().equals(player)  ){
                            System.out.println(" valid player and has piece on this panel");
                            if(counthold == true){
                                if( (tmpSquare.i%2 == 0 && tmpSquare.j%2 == 0) || (tmpSquare.i%2 == 1 && tmpSquare.j%2 == 1) ){
                                    tmpSquare.setBackground(Color.white);
                                 }else{
                                    tmpSquare.setBackground(Color.black);
                                }
                            }
                            tmpSquare = tmp;
                            counthold = true;    
                            System.out.println("get " + tmp.i + " " + tmp.j);
                            tmp.setBackground(Color.yellow);
                        }else if( ( counthold && tmpSquare.piece.isValidMove(squares, tmpSquare, tmp, player))){
                            System.out.println("put");
                            tmp.remove(tmp.getPiece());
                            tmp.repaint();
                            tmp.setPiece(tmpSquare.getPiece());
                            // tmp.setPiece(tmpSquare.piece.getName(), tmpSquare.piece.getColor());
                            tmpSquare.remove(tmpSquare.getPiece());                           

                            
                            if(squares[tmp.i][tmp.j].hasPiece){
                                System.out.println("squares[" + tmpSquare.i + "][" + tmpSquare.j + "].hasPiece() == true");
                            }else{
                                System.out.println("squares[" + tmpSquare.i + "][" + tmpSquare.j + "].hasPiece() == false");
                            }
                            tmp.hasPiece = true;
                            tmpSquare.repaint();
                            tmpSquare.setPiece(new Piece("", Color.green));
                            tmpSquare.validate();
                            tmp.validate();
                            //////////wait......
                            counthold = false;
                            if(player.equals(Color.red)){
                                player = Color.blue;
                            }else{
                                player = Color.red;
                            }
                            if( (tmpSquare.i%2 == 0 && tmpSquare.j%2 == 0) || (tmpSquare.i%2 == 1 && tmpSquare.j%2 == 1) ){
                                tmpSquare.setBackground(Color.white);
                            }else{
                                tmpSquare.setBackground(Color.black);
                            }
                            
                            squares[tmpSquare.i][tmpSquare.j].setHasPiece(false);         
                            
                            if(tmp.piece.isValidMove(squares, tmpSquare, tmp, player)){
                                System.out.println(" tmp.piece.isValidMove(squares, tmpSquare, tmp, player) == true ");
                            }else{
                                System.out.println("This is not valid move");
                            }
                            System.out.println("put " + tmp.i + " " + tmp.j);
                            
                            if (squares[tmpSquare.i][tmpSquare.j].hasPiece) {
                                System.out.println("squareFrom[" + tmpSquare.i + "][" + tmpSquare.j + "].hasPiece() == true");
                            } else {
                                System.out.println("squareFrom[" + tmpSquare.i + "][" + tmpSquare.j + "].hasPiece() == false");
                            }
                            if (squares[tmp.i][tmp.j].hasPiece()) {
                                System.out.println("squareTo[" + tmp.i + "][" + tmp.j + "].hasPiece() == true");
                            } else {
                                System.out.println("squareTo[" + tmp.i + "][" + tmp.j + "].hasPiece() == false");
                            }
                        } else {

                        }   
                    }                                 
                });
                count++;
                if (count % 2 == 1) {
                    squares[i][j].setBackground(Color.BLACK);
                } else {
                    squares[i][j].setBackground(Color.WHITE);
                }
                add(squares[i][j]);
            }
            count++;
        }

    }
    /*
    class menuActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == save){
                
            }
        }
        
    }*/
   
    
}
