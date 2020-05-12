package aitest.actors;

import aitest.Coordinate;

public class Character extends Actor{
	public Character(Coordinate c) {
		super(c);
	}
	private int health;
	private int panic;
	
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
}
