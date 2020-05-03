package enemy.ai.characters;

public class Character {
	private int health;
	private int panic;
	private String name;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
