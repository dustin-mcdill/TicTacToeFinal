package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeGameTest {
    private TicTacToeGame game;

    @BeforeEach
    public void setUp() {
        String simulatedInput = "5\n";
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

    @Test
    public void testInvalidThenValidMoveInput() {
        String simulatedInput = "abc\n10\n2\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        TicTacToeGame tempGame = new TicTacToeGame(scanner);
        int move = tempGame.getValidMove();
        assertEquals(2, move, "Should skip invalid inputs and accept 2");
    }
}
