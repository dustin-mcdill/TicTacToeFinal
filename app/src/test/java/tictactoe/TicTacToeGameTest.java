//also added a test for the game itself

package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TicTacToeGameTest {
    private TicTacToeGame game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToeGame();
    }

    @Test
    public void testValidMoveInput() {
        String simulatedInput = "5\n"; 
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        int move = game.getValidMove();
        System.setIn(originalSystemIn);

        assertEquals(5, move, "Valid move should be accepted");
    }
}