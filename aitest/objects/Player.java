package aitest.objects;

import aitest.Coordinate;

public class Player extends Actor {
	public Player(Coordinate c) {
		super(c);
		this.setName("Player");
		this.setMoves(3);
	}
}
