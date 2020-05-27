import java.util.Scanner;
/**
 * Escreva a descrição da classe Game aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
public class Game
{
    private String username;
    boolean gameStop;
    String choise;
    Scanner scan = new Scanner(System.in);
    RWFile fileRW;
    private GameScores gameScores;
    GameBoard gameBoard;

    public Game()
    {
        username = "";
        choise = "";
        gameStop = false;
        fileRW = new RWFile();
        gameScores = new GameScores();
        gameBoard = new GameBoard();
    }

    public boolean usernameIsValid(String username){
        boolean result = false;
        if(!username.isBlank() && username != null){
            result = true;
        }
        return result;
    }
    public void gameStart(){
        System.out.println("Write your username >");
        String tempUser = scan.next();
        if(usernameIsValid(tempUser)){
            username = tempUser;
        }
        System.out.println("Olá <" + username + ">\n\n");
        menu();
    }

    public void menu(){
        System.out.println("1 – Start new Game\n" +
                "2 – Load Game\n" +
                "3 – Personal Scores\n" +
                "4 – Ranking (TOP 10)\n" +
                "0 – Sair");
        do{
            System.out.println("\n>");
            choise = scan.next();

            switch(choise){
                case "0": System.out.println("Bye"); gameStop = true;break;
                case "1": newGame();break;
                case "2": ;break;
                case "3": ;break;
                case "4": showRankings();break;
                default: System.out.println("Invalid Option");
            }

        }while(!choise.equals("1") && !choise.equals("2") && !choise.equals("3") && !choise.equals("4") && !choise.equals("0") && !gameStop);
    }

    public void newGame(){
        System.out.println("1 – Start new Game – Basic Mode\n" +
                "2 – Start new Game – Advanced Mode\n" +
                "0 - Voltar");
        System.out.println("Olá <" + username + ">\n\n");
        do{
            System.out.println("\n>");
            choise = scan.next();

            switch(choise){
                case "0": menu();break;
                case "1": basicGameModeStart();break;
                case "2": ;break;
                default: System.out.println("Invalid Option");
            }

        }while(!choise.equals("1") && !choise.equals("2") && !choise.equals("0"));
    }

    public void showRankings(){
        fileRW.readRankingsFile("files/rankings.txt");
        gameScores.printScoreRanking();
    }

    public void basicGameModeStart(){
        gameBoard.showBoard();
    }
}

