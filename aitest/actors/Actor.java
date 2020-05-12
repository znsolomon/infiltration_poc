package aitest.actors;

import aitest.Coordinate;

public class Actor {
	private String name;
	private Coordinate position;
	
	public Actor(Coordinate c) {
		this.setPosition(c);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Coordinate getPosition() {
		return position;
	}
	protected void setPosition(Coordinate position) {
		this.position = position;
	}
	public void move(int[] vector) {
		Coordinate old = this.getPosition();
		Coordinate current = new Coordinate(old.getX()+vector[0],old.getY()+vector[1]);
		this.setPosition(current);
	}
}
