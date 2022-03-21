package genspark.john_manuel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class AppTest 
{
    App dragonApp;

    @BeforeEach
    void setUp() {
        dragonApp = new App();
    }

    @Test
    public void main() {
        assertEquals(false, dragonApp.dragonCave(), "running game");
    }

    @AfterEach
    void tearDown(){
    }
}
