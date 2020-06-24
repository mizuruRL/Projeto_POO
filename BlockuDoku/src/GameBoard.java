import java.io.Serializable;
import java.util.Arrays;

/**
 * Class responsible for representing the in-game board. The game board is a 2 dimensional array of [rows][columns],
 * where each position is represented by a boolean: false if position is empty and true if position is filled.
 * @author André Dias (190221068) e Tomás Barroso (190221029)
 * @version 1.0
 */
public class GameBoard implements Serializable {
    private int size;
    private boolean[][] board;

    public GameBoard() {
        board = new boolean[9][9];
        size = board.length;
        for (boolean[] row: board)
            Arrays.fill(row, false);
    }

    /**
     * Prints the game board to the screen.
     */
    public void show(){
        int count = 1;
        System.out.println(" | A | B | C | D | E | F | G | H | I ");
        for (boolean[] booleans : board) {
            System.out.print(count);

            for (boolean aBoolean : booleans) {
                System.out.print("|");
                if(aBoolean)
                System.out.print(" # ");
                else System.out.print(" . ");
            }
            count++;
            System.out.println();
        }

    }

    public int getSize() {
        return size;
    }

    public boolean[] getRow(int index) {
        return board[index];
    }

    public boolean[] getColumn(int index) {
        int size = getSize();
        boolean[] boardColumn = new boolean[size];
        for (int i = 0; i < size; i++) {
            boardColumn[i] = board[i][index];
        }
        return boardColumn;
    }

    /**
     * Custom getter method to return a 3x3 square of the board.
     * @param indexRow Initial row position.
     * @param indexColumn Initial column position.
     * @return 3x3 Matrix of the board from the specified indexes.
     */
    public boolean[][] getSquare(int indexRow, int indexColumn) {
        int size = indexRow + 3;
        boolean[][] boardSquare = new boolean[3][3];
        int i1 = 0;
        for(int x = indexRow; x < size && i1 < 3; x++){
            int i2 = 0;
            for(int y = indexColumn; y < size && i2 < 3; y++) {
                boardSquare[i1][i2] = board[x][y];
                i2++;
            }
            i1++;
        }
        return boardSquare;
    }

    /**
     * Cleans a chosen row.
     * @param index Index of the row.
     */
    public void cleanRow(int index){
        int size = getSize();
        for (int i = 0; i < size; i++){
            board[index][i] = false;
        }
    }

    /**
     * Cleans a chosen column.
     * @param index Index of the column.
     */
    public void cleanColumn(int index) {
        int size = getSize();
        for (int i = 0; i < size; i++) {
            board[i][index] = false;
        }
    }

    /**
     * Cleans a chosen 3x3 matrix inside the board. Starting position is top-left.
     * @param indexRow Starting position for row.
     * @param indexColumn Starting position for column.
     */
    public void cleanSquare(int indexRow, int indexColumn) {
        int size = indexRow + 3;
        for(int x = indexRow; x < size; x++) {
            for(int y = indexColumn; y < size; y++) {
                board[x][y] = false;
            }
        }
    }

    /**
     * Checks if chosen row is filled.
     * @param index Index of row.
     * @return Returns the boolean result of the check (true if filled, false if otherwise).
     */
    public boolean checkRow(int index){
        int size = getSize();
        boolean[] row = new boolean[size];
        Arrays.fill(row, true);
        return Arrays.equals(getRow(index), row);
    }

    /**
     * Checks if chosen column is filled.
     * @param index Index of column.
     * @return Returns the boolean result of the check (true if filled, false if otherwise).
     */
    public boolean checkColumn(int index){
        int size = getSize();
        boolean[] column = new boolean[size];
        boolean[] boardColumn = getColumn(index);
        Arrays.fill(column, true);
        return Arrays.equals(boardColumn, column);
    }

    /**
     * Checks if chosen 3x3 matrix is filled.
     * @param indexRow Starting position for row.
     * @param indexColumn Starting position for column.
     * @return Returns the boolean result of the check (true if filled, false if otherwise).
     */
    public boolean checkSquare(int indexRow, int indexColumn){
        boolean[][] boardSquare = getSquare(indexRow, indexColumn);
        boolean[][] square = new boolean[3][3];
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                square[x][y] = true;
            }
        }
        return Arrays.deepEquals(boardSquare, square);
    }

    /**
     * Method to check if a given block fits in the given position on the game board.
     * @param block Block to check.
     * @param locationX Coordinate x (column).
     * @param locationY Coordinate y (row).
     * @return Returns the boolean result of the check (true if possible, false if otherwise).
     */
    public boolean checkBlockPlacement(Block block, int locationX, int locationY) {
        boolean[][] content = block.getContent();
        int blockRowSize = block.getRowSize();
        int blockColumnSize = block.getColumnSize();
        boolean result = true;
        for (int x = 0; x < blockRowSize; x++) {
            for (int y = 0; y < blockColumnSize; y++) {
                boolean c = content[x][y];
                if(locationX + x >= size || locationY + y >= size) {result = false;break;}
                if (c) {
                    if(board[locationX + x][locationY + y]) {result = false;break;}
                }
            }
        }
        return result;
    }

    /**
     * Method to insert a given block's content in the game board.
     * @param block Block to insert.
     * @param locationX Coordinate x (column).
     * @param locationY Coordinate y (row).
     */
    public void insertBlock(Block block, int locationX, int locationY){
        boolean[][] content = block.getContent();
        int blockRowSize = block.getRowSize();
        int blockColumnSize = block.getColumnSize();
        if(checkBlockPlacement(block, locationX, locationY)) {
            for (int x = 0; x < blockRowSize; x++) {
                for (int y = 0; y < blockColumnSize; y++) {
                    if(content[x][y]) board[locationX + x][locationY + y] = true;
                }
            }
        }
    }
}
