package Tests;
import static org.junit.Assert.*;

import BlockGame.Game;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class TestUsername {
    private Game game;

    @Before
    public void setUp()
    {
        game = new Game();
    }

    @Test
    public void testName(){
        assertEquals(game.usernameIsValid("tb_ad"), true);
        assertEquals(game.usernameIsValid("tb_ad"), true);
        assertEquals(game.usernameIsValid(""), false);
    }

    @After
    public static void afterClass() throws Exception {

    }
}
