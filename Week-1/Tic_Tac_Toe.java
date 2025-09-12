import java.util.Scanner;

class Tic_Tac_Toe {
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

        System.out.println("Welcome to the Tic-Tac-Toe Game...\n");

        
        while (true) {
            System.out.println("Enter the cell number (1-9) to enter " + turn);
            int n = sc.nextInt();

            if (n < 1 || n > 9) {
                System.out.println("Invalid move. Please enter a number between 1 and 9.");
                continue;
            }

            if (board[n - 1].equals("X") || board[n - 1].equals("O")) {
                System.out.println("This cell is already occupied. Please try again.");
                continue;
            }
            
            board[n - 1] = turn;
            printBoard();
            checkWinner();
            iteration++;

            if (winner != null) {
                System.out.println("\nGame Over! " + winner + " wins!");
                break;
            } else if (iteration > 9) {
                System.out.println("\nGame Over! It's a draw!");
                break;
            } else {
                turn = turn.equals("X") ? "O" : "X";
            }
        }

    }
}