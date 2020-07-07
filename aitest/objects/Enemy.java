package aitest.objects;

import aitest.Coordinate;

public class Enemy extends Actor{
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
		this.setMoves(3);
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
