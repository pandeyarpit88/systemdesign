package tictactoe;

/**
 * Created by APandey1 on 17-11-2017.
 */
public class TicTacToe implements ITicTacToe {

    String board[][];
    Player p1, p2;
    Player turn;
    int moveCount = 0;

    public TicTacToe(String player1, String player2) {
        initBoard();
        initPlayers(player1, player2);
        initTurn();
    }

    private void initTurn() {
        turn = p1;
    }

    private void initPlayers(String player1, String player2) {
        p1 = new Player(player1, "X");
        p2 = new Player(player2, "O");
    }

    public void initBoard() {
        board = new String[3][3];
        for(int i=0; i<9; i++) {
            board[i/3][i%3] = String.valueOf(i+1);
        }
    }

    @Override
    public void printBoard() {
        for(int i=0; i<9; i++) {
            if(i%3==0)
                System.out.println();
            System.out.print("[" + board[i/3][i%3] + "]");
        }
        System.out.println();
    }

    @Override
    public boolean placeMove(int location) {
        int i = location-1;
        if(location > 9 || board[i/3][i%3].equalsIgnoreCase("X") || board[i/3][i%3].equalsIgnoreCase("O")) {
            System.out.println("Invalid move!!!! " + turn.getName() + " please enter a valid location");
            return false;
        } else {
            board[i/3][i%3] = turn.getMoveSymbol();
            switchTurn();
            moveCount++;
        }
        return true;
    }

    private boolean checkWin(int location) {
        if(moveCount < 5)
            return false;
        else {
            boolean win = true;
            int row = (location-1)/3;
            int col = (location-1)%3;
            //check col
            String val = board[row][0];
            for(int i=1; i<3; i++) {
                if(!val.equals(board[row][i]))
                    win = false;
            }
            if(win == true)
                return win;
            else
                win = true;

            //check row
            val = board[0][col];
            for(int i=1; i<3 ; i++) {
                if(!val.equals(board[i][col]))
                    win = false;
            }
            if(win == true)
                return win;
            else
                win = true;

            //check left diagonal
            val = board[0][0];
            for(int i=1; i<3; i++) {
                if(!val.equals(board[i][i]))
                    win = false;
            }
            if(win == true)
                return win;
            else
                win = true;

            //check right diagonal
            val = board[0][2];
            for(int i=1, j=1 ; i<3 && j>=0; i++, j--) {
                if(!val.equals(board[i][j]))
                    win = false;
            }
            return win;
        }
    }

    @Override
    public void switchTurn() {
        if(turn.equals(p1))
            turn = p2;
        else
            turn = p1;
    }

    public boolean gameOver(int location) {
        if(checkWin(location)) {
            if(turn.equals(p1))
                System.out.println("Congratulations.. " + p2.getName() + " wins the game");
            else
                System.out.println("Congratulations.. " + p1.getName() + " wins the game");
            return true;
        }

        if(moveCount == 9) {
            System.out.println("Game Draw");
            return true;
        }
        return false;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public Player getTurn() {
        return turn;
    }

    public void setTurn(Player turn) {
        this.turn = turn;
    }
}
