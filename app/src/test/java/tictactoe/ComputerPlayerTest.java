package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerTest {
    private ComputerPlayer ai;
    private GameBoard board;

    @BeforeEach
    public void setUp() {
        ai = new ComputerPlayer();
        board = new GameBoard();
    }

    @Test
    public void testFirstMoveChoosesCorner() {
        int move = ai.chooseMove(board, 'O', 'X', 0);
        List<Integer> corners = Arrays.asList(1, 3, 7, 9);
        assertTrue(corners.contains(move), "First move should be one of the corners");
    }

    @Test
    public void testSecondMoveChoosesCenter() {
        board.updateBoard(1, 'X'); // First move was corner
        int move = ai.chooseMove(board, 'O', 'X', 1);
        assertEquals(5, move, "Second move should be center if it's available");
    }

    @Test
    public void testCanWin() {
        board.updateBoard(1, 'O');
        board.updateBoard(2, 'O');
        board.updateBoard(4, 'X');
        board.updateBoard(5, 'X');
        int move = ai.chooseMove(board, 'O', 'X', 4);
        assertEquals(3, move, "AI should take winning move");
    }

    @Test
    public void testCanBlock() {
        board.updateBoard(1, 'X');
        board.updateBoard(2, 'X');
        int move = ai.chooseMove(board, 'O', 'X', 2);
        assertEquals(3, move, "AI should block opponent's win");
    }

    @Test
    public void testRandomMoveIfNoPriorityMove() {
        board.updateBoard(1, 'X');
        board.updateBoard(2, 'O');
        board.updateBoard(3, 'X');
        board.updateBoard(4, 'X');
        board.updateBoard(5, 'O');
        board.updateBoard(6, 'O');
        board.updateBoard(7, 'O');
        board.updateBoard(8, 'X');
        // Only move left is 9
        int move = ai.chooseMove(board, 'O', 'X', 8);
        assertEquals(9, move, "AI should pick the only available move");
    }
}
