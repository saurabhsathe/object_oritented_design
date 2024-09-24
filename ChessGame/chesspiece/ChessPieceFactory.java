package chesspiece;

import movestrategies.DiagnoalMoveStrategy;
import movestrategies.KingMoveStrategy;
import movestrategies.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class ChessPieceFactory {
    KingMoveStrategy  kingMoveStrategy;
    DiagnoalMoveStrategy  diagnoalMoveStrategy ;

    public ChessPieceFactory(){
        KingMoveStrategy  kingMoveStrategy= new KingMoveStrategy();
        DiagnoalMoveStrategy  diagnoalMoveStrategy = new DiagnoalMoveStrategy();
    }

    public Piece getInstance(char color, char pieceType){
        List<MoveStrategy> moves = new ArrayList<>();
        moves.add(kingMoveStrategy);
        return (Piece) new KingPiece(color,moves);

    }
}
