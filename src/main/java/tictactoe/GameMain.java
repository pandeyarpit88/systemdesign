package tictactoe;

import java.util.Scanner;

/**
 * Created by APandey1 on 17-11-2017.
 */
public class GameMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("welcome to game of tictactoe");
        System.out.print("Please enter first player name: ");
        String player1Name = in.nextLine();
        System.out.print("Please enter second player name: ");
        String player2Name = in.nextLine();
        System.out.println();
        TicTacToe t = new TicTacToe(player1Name, player2Name);
        int location;
        System.out.print("Please enter your move " + t.getTurn().getName() + ": ");
        location = in.nextInt();
        while(true) {
            Boolean validMove = t.placeMove(location);
            if(!validMove)
                continue;
            if(t.gameOver(location))
                break;
            t.printBoard();

            System.out.print("Please enter your move " + t.getTurn().getName() + ": ");
            location = in.nextInt();
        }
    }
}
