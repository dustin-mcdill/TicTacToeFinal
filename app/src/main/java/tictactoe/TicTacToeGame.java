package tictactoe;
import java.util.Scanner;

public class TicTacToeGame {
    private GameBoard board;
    private char currentPlayer;
    private Scanner scanner;

    public TicTacToeGame() {
        board = new GameBoard();
        currentPlayer = 'X';
        scanner = new Scanner(System.in);
    }

    public void play() {
        boolean playAgain;
        do {
            board.resetBoard();
            System.out.println("Welcome to Tic-Tac-Toe!");
            boolean gameWon = false;
            int moves = 0;

            while (!gameWon && moves < 9) {
                board.printBoard();
                System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
                int move = getValidMove();
                board.updateBoard(move, currentPlayer);
                moves++;

                if (board.checkWin(currentPlayer)) {
                    board.printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameWon = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            if (!gameWon) {
                board.printBoard();
                System.out.println("It's a draw!");
            }

            playAgain = askToPlayAgain();
        } while (playAgain);

        System.out.println("Goodbye!");
        scanner.close();
    }

    private int getValidMove() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.matches("[1-9]")) {
                System.out.print("Invalid input! Enter a number (1-9): ");
                continue;
            }
            int move = Integer.parseInt(input);
            if (board.isCellTaken(move)) {
                System.out.print("Cell already taken! Try again: ");
            } else {
                return move;
            }
        }
    }

    private boolean askToPlayAgain() {
        while (true) {
            System.out.print("Would you like to play again? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid entry! Please type 'yes' or 'no'.");
            }
        }
    }
}
