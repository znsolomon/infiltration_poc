package levels;

import aitest.Coordinate;

public abstract class Level {
	private int[] size;
	private Coordinate player;
	private Coordinate[] enemies;
	private Coordinate[] walls;
	public int[] getSize() {
		return size;
	}
	public void setSize(int[] size) {
		this.size = size;
	}
	public Coordinate getPlayer() {
		return player;
	}
	public void setPlayer(Coordinate player) {
		this.player = player;
	}
	public Coordinate[] getEnemies() {
		return enemies;
	}
	public void setEnemies(Coordinate[] enemies) {
		this.enemies = enemies;
	}
	public Coordinate[] getWalls() {
		return walls;
	}
	public void setWalls(Coordinate[] walls) {
		this.walls = walls;
	}
}
