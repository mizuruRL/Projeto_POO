public class Player {
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
}
