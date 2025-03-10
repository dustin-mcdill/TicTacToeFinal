//also added a test for the game itself

package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class TicTacToeGameTest {
    private TicTacToeGame game;

@BeforeEach
public void setUp() {
    String simulatedInput = "5\n";  // Simulated input for your tests
    Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
    game = new TicTacToeGame(scanner);
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