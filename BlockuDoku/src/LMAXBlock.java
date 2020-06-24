public class LMAXBlock extends Block{
	public LMAXBlock() {
		setContent(new boolean[3][3]);
		fillContent(false);
		content[0][0] = true;
		content[1][0] = true;
		content[2][0] = true;
		content[2][1] = true;
		content[2][2] = true;
	}
}
