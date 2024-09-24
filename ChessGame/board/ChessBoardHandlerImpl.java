package board;

import chesspiece.Piece;

public class ChessBoardHandlerImpl implements ChessBoardHandler {
    ChessBoard cb;
    int turn=1;
    int nextTurn=0;
    boolean isGameOver=false;
    int gameState=0;
    public ChessBoardHandlerImpl(ChessBoard cb){
        this.cb = cb;

    }


    @Override
    public boolean isValid(int row, int col) {
        return false;
    }

    @Override
    public boolean isGameOver() {
        return isGameOver;
    }

    @Override
    public String makeMove(int startRow, int startCol, int endRow, int endCol) {
        if(isGameOver) return "invalid";
        Piece startPiece=cb.getPiece(endRow, endCol);
        Piece endPiece=cb.getPiece(endRow, endCol);
        if(startPiece==null ||!isValid(endRow, endCol))
            return "invalid";
        if(endPiece!=null && endPiece.getColor()
                ==startPiece.getColor()) return "invalid";
        if(!startPiece.canMove(cb, startRow,
                startCol, endRow, endCol)) return "invalid";
        cb.setPiece(startRow,startCol,null);
        cb.setPiece(endRow,endCol,startPiece);
        nextTurn=nextTurn==0?1:0;
        if(endPiece!=null && endPiece.getType()=='K')
            gameState=endPiece.getColor()=='B'?1:2;
        if(endPiece==null) return "";
//  return "WP";
        return ""+endPiece.getColor()+endPiece.getType();
    }

    @Override
    public int getTurn() {
        return 0;
    }

    @Override
    public int getWinner() {
        return 0;
    }
}
