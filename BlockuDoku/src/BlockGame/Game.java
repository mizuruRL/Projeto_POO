package BlockGame;

import GameAssets.Blocks.*;
import FileHandler.RWFile;
import GameAssets.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 * Class responsible for all the game logic.
 *
 * @author André Dias (190221068) e Tomás Barroso (190221029)
 * @version 1.0
 */
public class Game implements Serializable
{
    private Block[] playableBlocks;
    private Random random;
    private boolean over;
    private String choice;
    private transient Scanner scan;
    private Scores personalScores;
    private Scores top10;
    private Board gameBoard;
    private boolean exit;
    private boolean newGame;
    private String[] values;
    private Mode gameMode;
    private Player player;
    private int round;
    private int moves;

    /**
     * Default constructor of class Game. Initializes attributes with predetermined values.
     */
    public Game()
    {
        player = new Player("User");
        choice = "";
        exit = false;
        over = false;
        personalScores = new Scores();
        gameBoard = new Board();
        playableBlocks = new Block[3];
        random = new Random();
        scan = new Scanner(System.in);
        gameMode = null;
        newGame = true;
        round = 1;
        moves = 3;
    }

    /**
     * Method that checks if the given username is valid.
     * @param username Name of the player.
     * @return Boolean result of check (true if valid, false if otherwise).
     */
    public boolean usernameIsValid(String username){
        boolean result = false;
        if(username != null && !username.trim().isEmpty()){
            result = true;
        }
        return result;
    }

    /**
     * Method to start the game.
     */
    public void start(){
        System.out.print("Write your username >");
        String nickname = scan.next();
        if(usernameIsValid(nickname)){
            player.setNickName(nickname);
        } else System.out.println("Invalid username, default \"User\" will be used");
        System.out.println("Olá <" + player.getNickName() + ">\n");
        menu();
    }

    private void menu(){
        System.out.println("1 – Start new game\n" +
                "2 – Load game\n" +
                "3 – Personal Scores\n" +
                "4 – Ranking (TOP 10)\n" +
                "0 – Sair");
        do{
            System.out.println("> ");
            choice = scan.next();

            switch(choice){
                case "0": System.out.println("GoodBye!"); over = true;break;
                case "1": newGame();menu();break;
                case "2": load();menu();break;
                case "3": showPersonalScores();menu();break;
                case "4": showRankings();menu();break;
                default: System.out.println("Invalid Option");
            }

        }while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("0") && !over);
    }

    private void newGame(){
        System.out.println("1 – Start new game – Basic Mode\n" +
                "2 – Start new game – Advanced Mode\n" +
                "0 - Voltar");
        do{
            System.out.println("> ");
            choice = scan.next();

            switch(choice){
                case "0": menu();break;
                case "1": reset();gameMode = Mode.BASIC;play();break;
                case "2": reset();gameMode = Mode.ADVANCED;play();break;
                default: System.out.println("Invalid Option");
            }

        }while(!choice.equals("1") && !choice.equals("2") && !choice.equals("0"));
    }

    private void reset(){
        player.setScore(0);
        gameBoard = new Board();
        round = 1;
        moves = 3;
        exit = false;
        over = false;
        newGame = true;
    }

    private void showRankings(){
        loadTop10Scores();
        if(top10 != null) {
        System.out.println("\n-------------TOP 10 SCORES-------------");
        System.out.println(top10.toString());
        }
    }

    private void gameSetup(){
        System.out.println(String.format("Round: %d | User: %s | Score: %d", round, player.getNickName(), player.getScore()));
        gameBoard.show();
        printPlayableBlocks();
    }

    /**
     * Method that checks if a command inputted by the user is valid during game.
     * @param command Command string to check.
     * @return Boolean result of check (true if valid, false if otherwise).
     */
    public boolean commandIsValid(String command){
        boolean result = false;
        values = command.split("-",2);
        if(command.equalsIgnoreCase("CANCEL")){
            exit = true;
        }else if(command.equalsIgnoreCase("SAVE")){
            save();
        }else if(command.trim().isEmpty() || values.length == 1){
            System.out.print("Invalid Command");
        }else if(!values[0].trim().isEmpty() && !values[1].trim().isEmpty()){
            result = true;
        }else{
            System.out.print("Choose a valid move");
        }
        return result;
    }



    private void play(){
        String command;
        boolean gameOver = false;
        if(newGame) {
            createPlayableBlocks(gameMode);
            newGame = false;
        }
        do{
            gameSetup();
             if(gameOver) {
                 System.out.println("NO MORE MOVES\n\n");
                 insertPersonalScore();
                 insertTop10Score();
                 saveTop10Scores();
                 break;
             }
            System.out.print("\nChoose the next move (Block-ColumnLine): ");
            command = scan.next();
            if(commandIsValid(command)){
                char pickedBlock = values[0].charAt(0);
                char locationY = values[1].charAt(0); //'A'
                int locationX = Integer.parseInt(String.valueOf(values[1].charAt(1)));// 1
                executeCommand(pickedBlock,locationX,locationY);
                checkForPoints();
                if(moves == 0) newRound();
                gameOver = !checkPossibleMoves();
            }
        }while (!exit);
        System.out.println("Thanks for playing!");
    }

    private void executeCommand(char pickedBlock, int locationX, char locationY){ // 'A', 1, 'A'
        if(Character.toUpperCase(pickedBlock) >= 'A' && Character.toUpperCase(pickedBlock) <= 'C'){
            if(Character.toUpperCase(locationY) >= 'A' && Character.toUpperCase(locationY) <= 'I'){
                if(locationX >= 1 && locationX <= 9){
                    makeMove(pickedBlock,locationX,locationY);
                }else{
                    System.out.println("Invalid Line position\n");
                }
            }else{
                System.out.println("Invalid column position\n");
            }
        }else{
            System.out.println("Invalid block\n");
        }
    }

    private Block createRandomBlock(Mode gamemode){
        Block block = null;
        if(gamemode == Mode.BASIC){
            int randomNumber = random.nextInt(7) + 1;
            switch(randomNumber){
                case 1: block = new IBlock();break;
                case 2: block = new QBlock();break;
                case 3: block = new TBlock();break;
                case 4: block = new LBlock();break;
                case 5: block = new JBlock();break;
                case 6: block = new SBlock();break;
                case 7: block = new ZBlock();break;
            }
        }else{
            int randomNumber = random.nextInt(14) + 1;
            switch(randomNumber){
                case 1: block = new IBlock();break;
                case 2: block = new QBlock();break;
                case 3: block = new TBlock();break;
                case 4: block = new LBlock();break;
                case 5: block = new JBlock();break;
                case 6: block = new SBlock();break;
                case 7: block = new ZBlock();break;
                case 8: block = new I1Block();break;
                case 9: block = new I2Block();break;
                case 10: block = new I3Block();break;
                case 11: block = new LMINBlock();break;
                case 12: block = new LMAXBlock();break;
                case 13: block = new TEBlock();break;
                case 14: block = new QEBlock();break;
            }
        }
        return block;
    }

    private void rotateBlock(Block block) {
        int randomNumber = random.nextInt(4) +1;
        for (int i = 0; i < randomNumber; i++){
            block.rotateContent();
        }
    }

    private void createPlayableBlocks(Mode gamemode){
        Arrays.setAll(playableBlocks, i -> createRandomBlock(gamemode));
        Arrays.stream(playableBlocks, 0, 3).forEach(this::rotateBlock);
    }

    private void printPlayableBlocks(){
        System.out.println("\nBlocos a jogar:\n\n");
        char blockPos = 'A';
        for (Block block : playableBlocks) {
            if (block != null) System.out.print("Bloco " + blockPos + "\n" + block.toString());
            blockPos++;
        }
    }


    private void removeFromPlayableBlocks(int index){
        playableBlocks[index] = null;
    }

    /**
     * Method that checks if a block exists in the playableBlocks array, in the specified index.
     * @param index Index to check.
     * @return Boolean result of check (true if it exists, false if otherwise).
     */
    public boolean existsInPlayableBlocks(int index){
        boolean result = false;
        if(index < playableBlocks.length && index != -1){
            Block b = playableBlocks[index];
            if(b != null) result = true;
        }
        return result;
    }

    private void makeMove(char pickedBlock, int locationX, char locationY){ // 'A', 1, 'A';
        int locationYIndex = Character.toUpperCase(locationY) - 'A'; // 0;
        int locationXIndex = locationX - 1; // 0
        int index = getIndexFromLetter(pickedBlock); // 0

        if(!existsInPlayableBlocks(index)) System.out.println("Block does not exist");
        else {
            Block block = playableBlocks[index];
            if(gameBoard.checkBlockPlacement(block, locationXIndex, locationYIndex)) {
                gameBoard.insertBlock(block, locationXIndex, locationYIndex);
                removeFromPlayableBlocks(index);
                reduceMove();
                addPlacementPoints(gameMode);
            } else System.out.println("Block cannot be placed here");
        }
    }

    private int getIndexFromLetter(char letter){
        int i = -1;
        switch (Character.toUpperCase(letter)) {
            case 'A': i = 0; break;
            case 'B': i = 1; break;
            case 'C': i = 2; break;
        }
        return i;
    }

    private void addPlacementPoints(Mode mode) {
        switch (mode) {
            case BASIC: player.addScore(1);break;
            case ADVANCED: player.addScore(2);break;
        }
    }

    private boolean checkPossibleMoves() {
        int size = gameBoard.getSize();
        for (Block block : playableBlocks) {
            if (block != null) {
                for (int x = 0; x < size; x++) {
                    for (int y = 0; y < size; y++) {
                        if (gameBoard.checkBlockPlacement(block, x, y)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void checkForPoints(){
        for(int i = 0; i < gameBoard.getSize(); i++) {
            if(gameBoard.checkColumn(i)){
                gameBoard.cleanColumn(i);
                player.addScore(36);
            }

            if(gameBoard.checkRow(i)){
                gameBoard.cleanRow(i);
                player.addScore(36);
            }
        }

        for(int x = 0; x < gameBoard.getSize(); x = x + 3) {
            for(int y = 0; y < gameBoard.getSize(); y = y +3)
                if(gameBoard.checkSquare(x, y)) {
                    gameBoard.cleanSquare(x, y);
                    player.addScore(46);
                }
        }
    }

    private void newRound(){
        moves = 3;
        round++;
        createPlayableBlocks(gameMode);
    }

    private void reduceMove(){
        moves--;
    }

    private void insertPersonalScore() {
        personalScores.insertScore(new Score(player));
    }

    private void showPersonalScores() {
        System.out.println("\n-------------PERSONAL SCORES-------------");
        System.out.println(personalScores.toString());
        System.out.println("\n");
    }

    private void saveTop10Scores() {
        RWFile.saveData("TOP10.rnk",top10);
    }

    private void insertTop10Score() {
        top10.insertScore(new Score(player));
    }

    private void loadTop10Scores() {
        top10 = (Scores) RWFile.loadData("TOP10.rnk");
    }

    private void load() {
        Game load = (Game) RWFile.loadData("saves/" + player.getNickName() + ".sav");
        if(load != null) {
            player = load.getPlayer();
            gameBoard = load.getGameBoard();
            over = load.isOver();
            playableBlocks = load.getPlayableBlocks();
            exit = load.isExit();
            personalScores = load.getPersonalScores();
            round = load.getRound();
            gameMode = load.getGameMode();
            moves = load.getMoves();
            newGame = load.getNewGame();
            play();
        }
    }

    private void save() {
        RWFile.saveData("saves/" + player.getNickName() + ".sav", this);
        exit = true;
    }

    public Block[] getPlayableBlocks() {
        return playableBlocks;
    }

    public boolean isOver() {
        return over;
    }

    public Scores getPersonalScores() {
        return personalScores;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public boolean isExit() {
        return exit;
    }

    public Mode getGameMode() {
        return gameMode;
    }

    public Player getPlayer() {
        return player;
    }

    public int getRound() {
        return round;
    }

    public int getMoves() {
        return moves;
    }

    public boolean getNewGame() {
        return newGame;
    }
}


