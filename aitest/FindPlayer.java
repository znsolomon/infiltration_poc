package aitest;

public class FindPlayer {
	/**
	 * enum for the different types of detection enemies can have for the player
	 * @author znsol
	 *
	 */
	enum Detect {
		PLAYER,			//The player's current position
		TURN1,			//Spaces the player has visited last turn
		TURN2			//Spaces the player has visited the turn before last
	}
	private Detect detect;
	private double distance;
	private Coordinate location;
	public FindPlayer(Detect det, double dis, Coordinate c) {
		this.detect = det;
		this.distance = dis;
		this.location = c;
	}
	public Detect getDetect() {
		return detect;
	}
	public double getDistance() {
		return distance;
	}
	public Coordinate getLocation() {
		return location;
	}
}
