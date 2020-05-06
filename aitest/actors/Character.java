package aitest.actors;

public class Character extends Actor{
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
