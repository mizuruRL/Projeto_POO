import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Class responsible for representing a score.
 * @author André Dias (190221068) e Tomás Barroso (190221029)
 * @version 1.0
 */
public class Score implements Comparable<Score>, Serializable {
	private Player player;
	private LocalDateTime timeStamp;

	/**
	 * Constructor of class Score. Scores are built when the player's game is over.
	 * @param player Player object.
	 */
	public Score (Player player){
		this.player = player;
		timeStamp = LocalDateTime.now();
	}
	public Player getPlayer() {
		return player;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	@Override
	public int compareTo(Score s) {
		return s.getPlayer().getScore() - this.getPlayer().getScore();
	}

	@Override
	public String toString() {
		String score;
		String formattedTime = getTimeStamp().format(DateTimeFormatter.ofPattern("d MMM uuuu HH:mm", Locale.ENGLISH));
		score = String.format("%s  Score: %d | %s", player.getNickName(), player.getScore(), formattedTime);
		return score;
	}
}
