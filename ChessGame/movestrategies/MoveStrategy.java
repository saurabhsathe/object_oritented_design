package movestrategies;

import board.ChessBoard;
import chesspiece.Piece;

public interface MoveStrategy {

    public boolean isMovePossible(ChessBoard cb, int curr_row,int curr_col, int end_row,int end_col);


}
