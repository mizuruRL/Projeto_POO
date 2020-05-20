import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;

public class RWFile {
    private GameScores gameScores;
    public RWFile() {
        gameScores = new GameScores();
    }

    public void readRankingsFile(String filename){
        try {
            File file = new File(filename);

            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                Player player = new Player();
                LocalDateTime date;

                String info = myReader.nextLine();

                String[] values = info.split(";");
                player.setNickName(values[0].replace("\"", "").trim());
                player.setScore(Integer.parseInt(values[1].replace("\"", "").trim()));
                date = LocalDateTime.parse(values[2].replace("\"", "").trim());

                if(filename.equalsIgnoreCase("rankings.txt")){
                    gameScores.addScoreRankingsList(player,date);
                }else{
                    gameScores.addPersonalScoreList(player,date);
                }


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }
    public void showRankings(){

        /*for(String data: rankingsList){

        }*/

    }
}
