package tictactoe;
import java.util.Scanner;

public class TicTacToeGame {
    private GameBoard board;
    private char currentPlayer;
    private Scanner scanner;
    private GameLog log;
    private GameMode mode;//added game mode
    private ComputerPlayer computer;//added ai player

    public TicTacToeGame(Scanner scanner) {
        board = new GameBoard();
        currentPlayer = 'X';
        this.scanner = scanner;
        log = new GameLog();

        mode = askGameMode();//asks for game mode

        if (mode != GameMode.HUMAN_VS_HUMAN) {//creates ai player if not human vs human
            computer = new ComputerPlayer();
        }
    }

    public void play() {
        boolean playAgain;
        char lastLoss = 'O';

        do {
            board.resetBoard();
            currentPlayer = (lastLoss == 'X') ? 'X' : 'O';
            System.out.println("\nWelcome to Tic-Tac-Toe!");
            boolean gameWon = false;
            int moves = 0;

            while (!gameWon && moves < 9) {
                board.printBoard();
                System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");

                int move;

                if (isComputersTurn()) {// computer plays if it's turn is up
                    move = computer.chooseMove(board, currentPlayer, (currentPlayer == 'X' ? 'O' : 'X'), moves);
                    System.out.println("Computer chose: " + move);
                } else {
                    move = getValidMove();
                }

                board.updateBoard(move, currentPlayer);
                moves++;

                if (board.checkWin(currentPlayer)) {
                    board.printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    log.recordAwin(currentPlayer);
                    gameWon = true;
                    lastLoss = (currentPlayer == 'X') ? 'O' : 'X';
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            if (!gameWon) {
                board.printBoard();
                System.out.println("It's a draw!");
                log.recordAtie();
            }

            log.printStat();

            playAgain = askToPlayAgain();//confirms new game and resets
            if (playAgain) {
                mode = askGameMode();
                if (mode != GameMode.HUMAN_VS_HUMAN) {
                    computer = new ComputerPlayer();
                }
            }

        } while (playAgain);

        log.saveFile();
        System.out.println("Goodbye!");
        scanner.close();
    }

    private boolean isComputersTurn() {//added a way to determine if it is computers turn
        return (mode == GameMode.HUMAN_VS_COMPUTER && currentPlayer == 'O')
            || (mode == GameMode.COMPUTER_VS_HUMAN && currentPlayer == 'X');
    }

    private GameMode askGameMode() { //shows menu at game start
        System.out.println("What kind of game would you like to play?");
        System.out.println("1. Human vs. Human");
        System.out.println("2. Human vs. Computer");
        System.out.println("3. Computer vs. Human");

        while (true) {
            System.out.print("What is your selection? ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1": return GameMode.HUMAN_VS_HUMAN;
                case "2": return GameMode.HUMAN_VS_COMPUTER;
                case "3": return GameMode.COMPUTER_VS_HUMAN;
                default: System.out.println("Invalid input! Enter 1, 2, or 3.");
            }
        }
    }

    int getValidMove() {
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
            if (input.equals("yes")) return true;
            else if (input.equals("no")) return false;
            else System.out.println("Invalid entry! Please type 'yes' or 'no'.");
        }
    }
}

