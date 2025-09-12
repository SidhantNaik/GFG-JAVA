import java.util.Scanner;

class Tic_Tac_To {
    static String[] board = new String[9];
    static String winner = null, turn = "X";

    static void printBoard() {
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
    }

    static void checkWinner() {

        String[] lines = {
                board[0] + board[1] + board[2], 
                board[3] + board[4] + board[5], 
                board[6] + board[7] + board[8], 
                board[0] + board[3] + board[6], 
                board[1] + board[4] + board[7], 
                board[2] + board[5] + board[8], 
                board[0] + board[4] + board[8], 
                board[2] + board[4] + board[6] 
        };

        for (String line : lines) {
            if (line.equals("XXX")) {
                winner = "X";
                return;
            } else if (line.equals("OOO")) {
                winner = "O";
                return;
            }
        }
    }

    public static void main(String[] args) {

        int iteration = 1;

        for (int i = 0; i < 9; i++)
            board[i] = "" + (i + 1);

        printBoard();

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Tic-Tac-To Game...\n");

        while (winner == null) {

            System.out.println("Enter the cell number to enter " + turn);
            int n = sc.nextInt();

            if (board[n - 1].equals("X") || board[n - 1].equals("O")) {
                System.out.println("The cell is already occupied one more time please,");
                continue;
            } else
                board[n - 1] = turn;

            printBoard();
            turn = turn.equals("X") ? "O" : "X";
            checkWinner();
            iteration++;

            if (winner == null && iteration > 9) {
                System.out.println("Match is draw");
                return;
            }
        }

        if (winner.equals("X"))
            System.out.println("Winner is X");
        else
            System.out.println("Winner is O");

    }
}