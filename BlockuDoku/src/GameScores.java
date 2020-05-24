import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GameScores {
    LinkedList<ValuedElement<Player>> scoreRankings;
    LinkedList<ValuedElement<Player>> personalScores;
    ValuedElement val;

    public GameScores() {
        scoreRankings = new LinkedList<>();
        personalScores = new LinkedList<>();
    }

    public void addScoreRankingsList(Player player, LocalDate date){
        val = new ValuedElement(player, date);
        //scoreRankings.addFirst(val);
        scoreRankings.add(val);
    }

    public void addPersonalScoreList(Player player, LocalDate date){
        val = new ValuedElement(player, date);
        personalScores.addFirst(val);
    }

    public void sortGamesScores(){

    }

    public void printScoreRanking(){
        System.out.println("-_-_-_-_-_-_-_ Rankings -_-_-_-_-_-_-_");
        System.out.println("Linked list : " + scoreRankings);
        for(ValuedElement<Player> val: scoreRankings){
            System.out.println(val.toString());

        }
    }
    public void printPersonalScores(){
        System.out.println("-_-_-_-_-_-_-_ Personal Scores -_-_-_-_-_-_-_");
        for(ValuedElement<Player> val: personalScores){
            val.toString();
        }
    }
}
