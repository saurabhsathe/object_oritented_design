package movestrategies;

import board.ChessBoard;

public class DiagnoalMoveStrategy implements MoveStrategy{
    public boolean isMovePossible(ChessBoard cb, int curr_row, int curr_col, int end_row, int end_col) {
        return false;
    }
}
