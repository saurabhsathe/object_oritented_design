package board;

import chesspiece.ChessPieceFactory;
import chesspiece.Piece;

public class ChessBoard {

    private Piece board[][];
    private ChessPieceFactory factory = new ChessPieceFactory();
    // 0 for game in progress, 1 for white has won, 2 for black has won
    private int gameState=0;
    // 0 for white , 1 for black,
    private int nextTurn=0;

    ChessBoard(String[][] chessboard){
        board=new Piece[chessboard.length][chessboard[0].length];
        for(int row=0;row<board.length;row++)
            for(int col=0;col<board[0].length;col++)
                if(chessboard[row][col].length()>=2){
                    char color=chessboard[row][col].charAt(0);
                    char type=chessboard[row][col].charAt(1);
                    board[row][col] = factory.getInstance(color, type);
                }
    }

    Piece getPiece(int row,int col){
        return board[row][col];

    }
    void setPiece(int row,int col,Piece p){
        board[row][col] =p;

    }
}
