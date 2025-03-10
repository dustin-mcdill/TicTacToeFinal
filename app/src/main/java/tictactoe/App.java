package tictactoe;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToeGame game = new TicTacToeGame(scanner);
        game.play();
        scanner.close();
    }
}

