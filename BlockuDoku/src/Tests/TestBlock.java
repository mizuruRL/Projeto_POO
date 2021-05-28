package Tests;
import BlockGame.Game;
import GameAssets.Board;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestBlock {
    private Game game;
    private Board board;


    @Before
    public void setUp()
    {
        game = new Game();
        board = new Board();
    }

    @Test
    public void testExistsInPlayableBlocks(){
        assertFalse(game.existsInPlayableBlocks(0));
        assertFalse(game.existsInPlayableBlocks(1));
        assertFalse(game.existsInPlayableBlocks(2));
    }

    @Test
    public void testCheckRow(){
        assertFalse(board.checkRow(0));
        assertFalse(board.checkRow(1));
        assertFalse(board.checkRow(2));
        assertFalse(board.checkRow(3));
    }

    @Test
    public void testCheckColumn(){
        assertFalse(board.checkColumn(0));
        assertFalse(board.checkColumn(1));
    }

    @Test
    public void testCheckSquare(){
        assertFalse(board.checkSquare(0, 0));
        assertFalse(board.checkSquare(1, 1));
    }
}
