package aitest.actors;

import aitest.Coordinate;

public class Enemy extends Character{
	public Enemy(Coordinate c, String name){
		super(c);
		this.setName(name);
	}
}
