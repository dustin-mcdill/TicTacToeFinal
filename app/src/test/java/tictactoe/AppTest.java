package tictactoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testMainRunsWithoutException() {
        String[] args = {};
        assertDoesNotThrow(() -> App.main(args));
    }
}

