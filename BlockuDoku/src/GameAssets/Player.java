package GameAssets;

import java.io.Serializable;

/**
 * Class responsible for representing a player in-game.
 * @author André Dias (190221068) e Tomás Barroso (190221029)
 * @version 1.0
 */
public class Player implements Comparable<Player>, Serializable {
    private String nickName;
    private int score;

    public Player(){
        this.score = 0;
    }

    public Player(String nickName) {
        this.nickName = nickName;
        this.score = 0;
    }

    public String getNickName() {
        return nickName;
    }

    public int getScore() {
        return score;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setScore(int totalScore) {
        this.score = totalScore;
    }

    @Override
    public String toString() {
        return "NickName=" + nickName + " | Score=" + score;
    }

    @Override
    public int compareTo(Player p) {
        return p.getScore() - score;
    }

    /**
     * Increments the player's current score by adding into it any int value.
     * @param points Points to increment score by.
     */
    public void addScore(int points){
        score += points;
    }
}
