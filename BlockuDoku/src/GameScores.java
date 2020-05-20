import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GameScores {
    List<ValuedElement<Player>> scoreRankings;
    List<ValuedElement<Player>> personalScores;

    public GameScores() {
        scoreRankings = new LinkedList<>();
        personalScores = new LinkedList<>();
    }

    public void addScoreRankingsList(Player player, LocalDateTime date){
        ValuedElement val = new ValuedElement(player, date);
        scoreRankings.add(val);
    }

    public void addPersonalScoreList(Player player, LocalDateTime date){
        ValuedElement val = new ValuedElement(player, date);
        personalScores.add(val);
    }

    public void sortGamesScores(){

    }

    public void printScoreRanking(){
        System.out.println("-_-_-_-_-_-_-_ Rankings -_-_-_-_-_-_-_");
        for(ValuedElement<Player> val: scoreRankings){
            val.toString();
        }

    }
    public void printPersonalScores(){
        System.out.println("-_-_-_-_-_-_-_ Personal Scores -_-_-_-_-_-_-_");
        for(ValuedElement<Player> val: personalScores){
            val.toString();
        }
    }
}
