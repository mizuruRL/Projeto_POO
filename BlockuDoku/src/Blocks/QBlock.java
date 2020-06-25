package Blocks;

public class QBlock extends Block{

	/**
	 * Constructor of class Blocks.Block. Only the needed space for a block to be represented is built.
	 *
	 */
	public QBlock() {
		setContent(new boolean[2][2]);
		fillContent(true);
	}
}
