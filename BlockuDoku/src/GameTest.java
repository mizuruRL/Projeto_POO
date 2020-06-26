import static org.junit.Assert.*;

import BlockGame.Game;
import GameAssets.Board;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
	private Game game;
	private Board board;
	@Before
	public void setUp()
	{
		game = new Game();
		board = new Board();
	}

	@Test
	public void testName(){
		assertTrue(game.usernameIsValid("tb_ad"));
		assertTrue(game.usernameIsValid("tb_ad"));
		assertFalse(game.usernameIsValid(""));
		assertTrue(game.usernameIsValid("1"));
	}

	@Test
	public void testCommandIsValid(){
		assertTrue(game.commandIsValid("A-A1"));
		assertFalse(game.commandIsValid("A"));
		assertFalse(game.commandIsValid("AHAHAHA"));
		assertTrue(game.commandIsValid("c-A1"));
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

	@After
	public void tearDown()
	{

	}
}
