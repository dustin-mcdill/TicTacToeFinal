package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class GameLogTest {
    private GameLog log;

    @BeforeEach
    public void setUp() {
        log = new GameLog();
    }

    @Test
    public void testRecordWinAndTie() {
        log.recordAwin('X');
        log.recordAwin('O');
        log.recordAtie();
        log.saveFile();

        File file = new File("game_log.txt");
        assertTrue(file.exists(), "Log file should be created");

    }
}
