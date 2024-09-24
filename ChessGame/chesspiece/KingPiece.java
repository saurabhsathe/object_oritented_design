package chesspiece;

import board.ChessBoard;
import movestrategies.KingMoveStrategy;
import movestrategies.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class KingPiece implements Piece{
    char color;
    char type;
    List<MoveStrategy> moves;
    public KingPiece(char color, List moves){
        this.type='K';
        this.color= color;
        this.moves = moves;

    }
    public boolean canMove(ChessBoard cb,int curr_row, int curr_col, int dest_row, int dest_col) {
        return false;
    }

    @Override
    public char getColor() {
        return color;
    }

    @Override
    public char getType() {
        return type;
    }
}
