package Tests;
import BlockGame.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCommand {
    private Game game;

    @Before
    public void setUp()
    {
        game = new Game();
    }

    @Test
    public void testCommand(){
        assertEquals(game.commandIsValid("A-A1"), true);
        assertEquals(game.commandIsValid("A"), false);
        assertEquals(game.commandIsValid("AHAHAHA"),false);
    }
}
