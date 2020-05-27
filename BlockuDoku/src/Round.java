public class Round {
    private int move;
    private int round;

    public Round() {
        this.move = 3;
        this.round = 1;
    }

    public int getMove() {
        return move;

    }

    public void setMove(int move) {
        this.move = move;
    }

    public void decreseMove(){
        this.move--;
    }

    public int getRound() {
        return round;
    }

    public void nextRound() {
        this.round = round++;
    }

    public void playableBlocks(){

    }
}
