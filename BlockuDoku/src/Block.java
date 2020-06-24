import java.io.Serializable;
import java.util.Arrays;

/**
 * Class responsible for representing a block in-game. Blocks are built on a 2 dimensional array of [rows][columns],
 * depending on BlockType.
 * @author André Dias (190221068) e Tomás Barroso (190221029)
 * @version 1.0
 */
public abstract class Block implements Serializable {
    boolean[][] content;

    public Block() {
        content = null;
    }

    public void setContent(boolean[][] content) {
        this.content = content;
    }

    public boolean[][] getContent() {
        return content;
    }

    public int getRowSize() {
        return content.length;
    }

    public int getColumnSize() {
        return content[0].length;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        for(boolean[] row : content) {
            info.append(Arrays.toString(row)
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "")
                    .replace("false", " ")
                    .replace("true", "#")).append("\n");
        }
        return info + "\n";
    }

    /**
     * Method that rotates a block's content matrix by 90º.
     */
    public void rotateContent() {
        int rowSize = getRowSize();
        int columnSize = getColumnSize();
        boolean[][] rotatedContent = new boolean[columnSize][rowSize];

        for(int x = 0; x < rowSize; x++) {
            for (int i = columnSize-1 , y = 0; i >= 0 && y < columnSize; i--, y++) {
                rotatedContent[i][x] = content[x][y];
            }
        }
        setContent(rotatedContent);
    }

    void fillContent(boolean val) {
        for (boolean[] row: content)
            Arrays.fill(row, val);
    }

}
