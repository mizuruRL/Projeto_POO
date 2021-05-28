package GameAssets.Blocks;

public class JBlock extends Block{

	/**
	 * Constructor of class Blocks.Block. Only the needed space for a block to be represented is built.
	 *
	 */
	public JBlock() {
		setContent(new boolean[3][2]);
		fillContent(false);
		content[0][1] = true;
		content[1][1] = true;
		content[2][1] = true;
		content[2][0] = true;
	}


}
