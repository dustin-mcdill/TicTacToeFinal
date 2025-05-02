package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameLogTest {
    private GameLog log;
    private final String fileName = "game_log.txt";

    @BeforeEach
    public void setUp() {
        log = new GameLog();
        File file = new File(fileName);
        if (file.exists()) file.delete();
    }

    @Test
    public void testSaveFileCreatesLog() {
        log.recordAwin('X');
        log.recordAwin('O');
        log.recordAtie();
        log.saveFile();

        File file = new File(fileName);
        assertTrue(file.exists(), "Log file should be created");
    }

    @Test
    public void testLogFileContent() throws IOException {
        log.recordAwin('X');
        log.recordAwin('X');
        log.recordAwin('O');
        log.recordAtie();
        log.recordAtie();
        log.saveFile();

        List<String> lines = Files.readAllLines(new File(fileName).toPath());
        assertTrue(lines.contains("Player X Wins: 2"), "Should log 2 X wins");
        assertTrue(lines.contains("Player O Wins: 1"), "Should log 1 O win");
        assertTrue(lines.contains("Number of Ties: 2"), "Should log 2 ties");
    }
}
