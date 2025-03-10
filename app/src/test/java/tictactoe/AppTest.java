package tictactoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    public void testGameInitialization() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest, "App should be initialized properly");
    }
}
