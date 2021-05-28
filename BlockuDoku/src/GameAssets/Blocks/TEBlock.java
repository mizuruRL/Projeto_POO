package GameAssets.Blocks;

public class TEBlock extends Block{
	public TEBlock() {
		setContent(new boolean[3][3]);
		fillContent(false);
		content[0][0] = true;
		content[0][1] = true;
		content[0][2] = true;
		content[1][1] = true;
		content[2][1] = true;
	}


}
