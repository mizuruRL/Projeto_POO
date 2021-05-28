package GameAssets.Blocks;

public class ZBlock extends Block{

	/**
	 * Constructor of class Blocks.Block. Only the needed space for a block to be represented is built.
	 *
	 */
	public ZBlock() {
		setContent(new boolean[2][3]);
		fillContent(false);
		content[0][0] = true;
		content[0][1] = true;
		content[1][1] = true;
		content[1][2] = true;
	}

}
