package levels;

import aitest.Coordinate;

public class One extends Level{
	public One() {
		this.setSize(new int[] {8,8});
		this.setPlayer(new Coordinate(0,0));
		this.setEnemies(new Coordinate[] {new Coordinate(8,0), new Coordinate(8,8)});
	}
}
