import java.util.ArrayList;

public class GameBoard {

    char board[][];

    public GameBoard() {
        board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                board[i][k] = '.';
            }
        }
    }

    public void showBoard(){
        int count = 1;
        System.out.println(" | A | B | C | D | E | F | G | H | I ");
        for (int i = 0; i < board.length; i++) {
            System.out.print(count);
            //this equals to the row in our matrix.
            for (int j = 0; j < board[i].length; j++) {   //this equals to the column in each row.
                System.out.print("|");
                System.out.print(" " + board[i][j] + " ");
            }
            count++;
            System.out.println(); //change line on console as row comes to end in the matrix.
        }

    }

    public boolean insertBoard(ArrayList list){
        boolean result = false;
        if(check(list)) {
            for (Object o : list) {
                String position = o.toString();
                char x = position.charAt(0);
                char y = position.charAt(1);
                board[x][y] = '#';
            }
            result = true;
        }
        return result;
    }

    public boolean check(ArrayList list){
        boolean result = false;
        int count = 0;
        for(int a = 0; a < list.size(); a++){
            String position = list.get(a).toString();
            char x = position.charAt(0);
            char y = position.charAt(1);

            if(board[x][y] != '#'){
                count++;
            }

        }
        if(count == list.size()){
            result = true;
        }
        return result;
    }

    public boolean checkLine(){
        boolean result = false;
        int count = 0;

        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                if(board[x][y] == '#'){
                    count++;
                }
            }
        }
        if(count == 9){
            result = true;
        }
        return  result;
    }

    public boolean checkColumn(){
        boolean result = false;
        int count = 0;

        for(int y = 0; y < 10; y++){
            for(int x = 0; x < 10; x++){
                if(board[x][y] == '#'){
                    count++;
                }
            }
        }
        if(count == 9){
            result = true;
        }
        return  result;
    }

    public boolean checkSquare(){
        boolean result = false;
        int count = 0;

        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {

            }

        }
        }
    }
}
