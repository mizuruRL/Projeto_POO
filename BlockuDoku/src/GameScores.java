import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class GameScores {
    List<ValuedElement<Player>> scores;

    public GameScores() {
        scores = new LinkedList<>();
    }

    public void addScoresList(Player player, int score, LocalDateTime date){
        ValuedElement val = new ValuedElement(player, score, date);
        scores.add(val);
    }
}
