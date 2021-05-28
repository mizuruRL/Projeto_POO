package GameAssets.Blocks;

public class IBlock extends Block{

	/**
	 * Constructor of class Blocks.Block. Only the needed space for a block to be represented is built.
	 *
	 */
	public IBlock() {
		setContent(new boolean[4][1]);
		content[0][0] = true;
		content[1][0] = true;
		content[2][0] = true;
		content[3][0] = true;
	}


}
