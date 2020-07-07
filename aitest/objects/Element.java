package aitest.objects;

import aitest.Coordinate;
import library.Physics;

public class Element {
	private String name;
	private Coordinate position;
	
	public Element(Coordinate c) {
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
		Coordinate current = new Coordinate(Physics.addVectors(old.toArr(), vector));
		this.setPosition(current);
	}
}
