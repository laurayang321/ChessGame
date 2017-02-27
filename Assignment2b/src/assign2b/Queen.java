package assign2b;

import java.awt.Color;

/**
 * Queen – can move in any direction unlimited number of spaces 
 * as long as the way is clear of other pieces
 * @author Jing
 */
public class Queen extends Piece {

    /**
     * Queen Constructor
     * @param str "Q" 
     * @param color player's color
     */
    public Queen(String str, Color color) {
        super("Q", color);
    }

    
    boolean isValidMove(Square[][] squares, Square squareFrom, Square squareTo, Color player) {
        int i1 = squareFrom.i;
        int i2 = squareTo.i;
        int j1 = squareFrom.j;
        int j2 = squareTo.j;
        boolean result = false;
        int i, j;
        if ((squareFrom.getPiece().getColor().equals(player) && !squareTo.getPiece().getColor().equals(player))) {
            if (Math.abs(i2 - i1) == Math.abs(j2 - j1)) {
                if (i2 > i1 && j2 > j1) {
                    for (i = (i1 + 1), j = (j1 + 1); i < i2; i++, j++) {
                        if (squares[i][j].hasPiece == true) {
                            return false;
                        }
                    }
                    return true;
                } else if (i2 < i1 && j2 > j1) {
                    for (i = (i2 + 1), j = (j1 + 1); i < i1; i++, j++) {
                        if (squares[i][j].hasPiece == true) {
                            return false;
                        }
                    }
                    return true;
                } else if (i2 > i1 && j2 < j1) {
                    for (i = (i1 + 1), j = (j2 + 1); i < i2; i++, j++) {
                        if (squares[i][j].hasPiece == true) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    for (i = (i2 + 1), j = (j2 + 1); i < i1; i++, j++) {
                        if (squares[i][j].hasPiece == true) {
                            return false;
                        }
                    }
                    return true;
                }
            } else if (j2 - j1 == 0) {
                System.out.println("Vertical");
                if (i2 - i1 < 0) {
                    System.out.println("move up");
                    for (i = (i2 + 1); i < i1; i++) {
                        if (squares[i][j1].hasPiece() == true) {
                            //System.out.println(i + " " + j1 + " ");
                            if (squares[i][j1].hasPiece() == true) {
                                System.out.println("squares[" + i + "][" + j1 + "].hasPiece() == true");
                            } else {
                                System.out.println("squares[" + i + "][" + j1 + "].hasPiece() == false");
                            }
                            return false;
                        }
                    }
                    return true;
                } else {
                    System.out.println("move down");
                    for (i = (i1 + 1); i < i2; i++) {
                        if (squares[i][j1].hasPiece() == true) {
                            return false;
                        }
                    }
                    return true;
                }

            } else if (i2 - i1 == 0) {
                System.out.println("Horizontal");
                if (j2 - j1 < 0) {
                    System.out.println("move left");
                    for (j = (j2 + 1); j < j1; j++) {
                        if (squares[i1][j].hasPiece() == true) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    System.out.println("move right");
                    for (j = (j1 + 1); j < j2; j++) {
                        if (squares[i1][j].hasPiece() == true) {
                            return false;
                        }
                    }
                    return true;
                }
            }else{
                System.out.println("Not correct direction");
                return false;
            }
        } else {
            System.out.println("get my piece, put not my piece");
            return false;
        }
    }
}
