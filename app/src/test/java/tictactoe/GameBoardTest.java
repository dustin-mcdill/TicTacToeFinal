//added test for the game board

package tictactoe;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameBoardTest {
    private GameBoard board;

    @BeforeEach
    public void setUp() {
        board = new GameBoard();
    }

    @Test
    public void testBoardInitialization() {
        board.resetBoard();
        assertEquals('1', board.getBoard()[0][0], "Top-left cell should be '1'");
        assertEquals('9', board.getBoard()[2][2], "Bottom-right cell should be '9'");
    }

    @Test
    public void testBoardUpdate() {
        board.updateBoard(5, 'X');
        assertEquals('X', board.getBoard()[1][1], "Cell 5 should be updated to 'X'");
    }

    @Test
    public void testWinConditionRow() {
        board.updateBoard(1, 'X');
        board.updateBoard(2, 'X');
        board.updateBoard(3, 'X');
        assertTrue(board.checkWin('X'), "Player X should win with top row filled");
    }

    @Test
    public void testWinConditionColumn() {
        board.updateBoard(1, 'O');
        board.updateBoard(4, 'O');
        board.updateBoard(7, 'O');
        assertTrue(board.checkWin('O'), "Player O should win with left column filled");
    }

    @Test
    public void testWinConditionDiagonal() {
        board.updateBoard(1, 'X');
        board.updateBoard(5, 'X');
        board.updateBoard(9, 'X');
        assertTrue(board.checkWin('X'), "Player X should win with diagonal");
    }

    @Test
    public void testCellAlreadyTaken() {
        board.updateBoard(5, 'X');
        assertTrue(board.isCellTaken(5), "Cell 5 should be marked as taken");
    }
}