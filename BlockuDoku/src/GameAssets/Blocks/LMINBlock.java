package GameAssets.Blocks;

public class LMINBlock extends Block{
	public LMINBlock() {
		setContent(new boolean[2][2]);
		fillContent(false);
		content[0][0] = true;
		content[1][0] = true;
		content[1][1] = true;
	}
}
