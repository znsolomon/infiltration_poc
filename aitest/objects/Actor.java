package aitest.objects;

import aitest.Coordinate;

public class Actor extends Element{
	public Actor(Coordinate c) {
		super(c);
	}
	private int health;
	private int panic;
	private int moves;
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getPanic() {
		return panic;
	}
	public void setPanic(int panic) {
		this.panic = panic;
	}
	public int getMoves() {
		return moves;
	}
	public void setMoves(int moves) {
		this.moves = moves;
	}
}
