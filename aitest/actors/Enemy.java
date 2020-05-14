package aitest.actors;

import aitest.Coordinate;

public class Enemy extends Character{
	private Coordinate target;
	enum Type{
		RUSH
	}
	private Type ai;
	public Enemy(Coordinate c, String name, int type){
		super(c);
		this.setName(name);
		switch (type){
		case 0:
			setAi(Type.RUSH);
			break;
		default:
			break;
		}
	}
	public Coordinate getTarget() {
		return target;
	}
	public void setTarget(Coordinate target) {
		this.target = target;
	}
	public Type getAi() {
		return ai;
	}
	public void setAi(Type ai) {
		this.ai = ai;
	}
}
