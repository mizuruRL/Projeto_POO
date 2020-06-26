package GameAssets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class responsible for representing a score list in-game.
 * @author André Dias (190221068) e Tomás Barroso (190221029)
 * @version 1.0
 */
public class Scores implements Serializable {
    private List<Score> scores;

    /**
     * Constructor of class GameAssets.GameScores. Initializes score List.
     */
    public Scores() {
        scores = new ArrayList<>();
    }

    public void insertScore(Score s) {
        scores.add(s);
    }

    public void sortRanks() {
        Collections.sort(scores);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        sortRanks();
        int rank = 1;
        for (Score score:scores) {
            info.append(String.format("\n%d - %s", rank, score.toString()));
            rank++;
        }
        while(rank<=10) {
            info.append(String.format("\n%d - ", rank));
            rank++;
        }
        return info.toString();
    }
}
