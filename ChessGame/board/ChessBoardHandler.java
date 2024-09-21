package board;

public interface ChessBoardHandler {


    public boolean isValid(int row, int col);
    public boolean isGameOver();
    public String makeMove(int start_row, int start_col,int end_row, int end_col);
    public int getTurn();
    public int getWinner();

}
