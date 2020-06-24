public class LBlock extends Block{

	/**
	 * Constructor of class Block. Only the needed space for a block to be represented is built.
	 *
	 */
	public LBlock() {
		setContent(new boolean[3][2]);
		fillContent(false);
		content[0][0] = true;
		content[1][0] = true;
		content[2][0] = true;
		content[2][1] = true;
	}
}
