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

    public void readRankingsFile(){
        System.out.println("-_-_-_-_-_-_-_ Rankings -_-_-_-_-_-_-_");
        try {
            File file = new File("files/rankings.txt");

            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                Player player = new Player();
                int score;
                LocalDateTime date;

                String info = myReader.nextLine();
                String[] values = info.split(";");
                player.setNickName(values[0].replace("\"", "").trim());
                values[1] = values[1].replace("\"", "").trim();
                values[2] = values[2].replace("\"", "").trim();



                gameScores.addScoresList();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }
    public void showRankings(){

        for(String data: rankingsList){

        }

    }
}
