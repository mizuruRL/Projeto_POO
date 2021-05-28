package GameAssets.Blocks;

public class TBlock extends Block{

	/**
	 * Constructor of class Blocks.Block. Only the needed space for a block to be represented is built.
	 *
	 */
	public TBlock() {
		setContent(new boolean[2][3]);
		fillContent(false);
		content[0][0] = true;
		content[0][1] = true;
		content[0][2] = true;
		content[1][1] = true;

	}

}
