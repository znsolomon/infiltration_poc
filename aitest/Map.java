package aitest;

import aitest.actors.*;

public class Map {
	public Actor[][] Grid;
	public Map(int width, int height, Coordinate player, Coordinate[] enemies){
		Grid = new Actor[width][height];
		Grid[player.getX()][player.getY()] = new Player();
		for(Coordinate c : enemies) {
			Grid[c.getX()][c.getY()] = new Enemy();
		}
	}
	
	public String[][] printGrid() {
		Actor current;
		int height = Grid[0].length;
		String[][] result = new String[Grid.length][height];
		for (int x=0; x<Grid.length; x++) {
			for (int y=0; y<height; y++) {
				current = Grid[x][y];
				if(current == null) {
					result[x][y] = "Empty";
				}
				else {
					result[x][y] = current.getName();
				}
			}
		}
		return result;
	}
}
