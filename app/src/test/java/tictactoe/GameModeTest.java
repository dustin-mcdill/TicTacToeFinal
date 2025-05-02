package tictactoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameModeTest {

    @Test
    public void testEnumValues() {
        GameMode[] modes = GameMode.values();
        assertEquals(3, modes.length, "There should be 3 game modes");
        assertEquals(GameMode.HUMAN_VS_HUMAN, GameMode.valueOf("HUMAN_VS_HUMAN"));
        assertEquals(GameMode.HUMAN_VS_COMPUTER, GameMode.valueOf("HUMAN_VS_COMPUTER"));
        assertEquals(GameMode.COMPUTER_VS_HUMAN, GameMode.valueOf("COMPUTER_VS_HUMAN"));
    }
}
