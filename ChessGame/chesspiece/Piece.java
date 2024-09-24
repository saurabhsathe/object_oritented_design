package chesspiece;

import board.ChessBoard;
import movestrategies.MoveStrategy;

import java.util.List;

public interface Piece {
    public boolean canMove(ChessBoard cb,int curr_row, int curr_col, int dest_row, int dest_col);
    public char getColor();
    public char getType();

}
