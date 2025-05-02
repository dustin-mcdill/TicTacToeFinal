package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// opportunistic ai player class that can follow certain rules to play
public class ComputerPlayer {
    private final Random random = new Random();

    public int chooseMove(GameBoard board, char computerChar, char opponentChar, int moveCount) {
        List<Integer> availableMoves = getAvailableMoves(board);

        //If first move, take a corner
        if (moveCount == 0) {
            for (int corner : new int[]{1, 3, 7, 9}) {
                if (!board.isCellTaken(corner)) return corner;
            }
        }

        //If second move and center is available
        if (moveCount == 1 && !board.isCellTaken(5)) {
            return 5;
        }

        // Rule 3: Can win
        for (int move : availableMoves) {
            GameBoard temp = cloneBoard(board);
            temp.updateBoard(move, computerChar);
            if (temp.checkWin(computerChar)) return move;
        }

        // Can/Cant block
        for (int move : availableMoves) {
            GameBoard temp = cloneBoard(board);
            temp.updateBoard(move, opponentChar);
            if (temp.checkWin(opponentChar)) return move;
        }

        // If nothing else, then random move
        return availableMoves.get(random.nextInt(availableMoves.size()));
    }

    // creates a list of empty positions
    private List<Integer> getAvailableMoves(GameBoard board) {
        List<Integer> moves = new ArrayList<>();
        char[][] b = board.getBoard();
        for (int i = 0; i < 9; i++) {
            int row = i / 3, col = i % 3;
            if (b[row][col] != 'X' && b[row][col] != 'O') {
                moves.add(i + 1);
            }
        }
        return moves;
    }

    //clones the board
    private GameBoard cloneBoard(GameBoard original) {
        GameBoard clone = new GameBoard();
        char[][] newBoard = clone.getBoard();
        char[][] oldBoard = original.getBoard();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                newBoard[i][j] = oldBoard[i][j];
        return clone;
    }
}
