package tictactoe;

/**
 * Created by APandey1 on 17-11-2017.
 */
public interface ITicTacToe {
    void printBoard();
    boolean placeMove(int location);
    void switchTurn();
    boolean gameOver(int location);
}
