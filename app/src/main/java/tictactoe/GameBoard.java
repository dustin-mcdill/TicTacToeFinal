package tictactoe; 

public class GameBoard {
    private char[][] board;

    public GameBoard() {
        board = new char[3][3];
        resetBoard();
    }

    public void resetBoard() {
        char num = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = num++;
            }
        }
    }

    public void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println("  " + board[i][0] + "  |  " + board[i][1] + "  |  " + board[i][2]);
            if (i < 2) System.out.println("-----+-----+-----");
        }
        System.out.println();
    }

    public void updateBoard(int move, char player) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        board[row][col] = player;
    }

    public boolean isCellTaken(int move) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        return board[row][col] == 'X' || board[row][col] == 'O';
    }

    public boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;
        return false;
    }
}
