public class Player {
    private String nickName;

    private int totalPoints;

    public Player(){
        this.totalPoints = 0;
    }

    public Player(String nickName) {
        this.nickName = nickName;
        this.totalPoints = 0;
    }

    public String getNickName() {
        return nickName;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
