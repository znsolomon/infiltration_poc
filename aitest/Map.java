package aitest;

import java.util.HashMap;

import aitest.actors.*;

public class Map {
	public HashMap<String,Actor> objects = new HashMap<String,Actor>();
	public String[][] grid;
	public Map(int width, int height, Coordinate p, Coordinate[] e, Coordinate[] walls){
		grid = new String[width][height];
		objects.put("player", new Player(p));
		grid[p.getX()][p.getY()] = "player";
		int eCount = 0;
		for(Coordinate c : e) {
			String key = "enemy" + Integer.toString(eCount+1);
			objects.put(key, new Enemy(e[eCount]));
			grid[c.getX()][c.getY()] = key;
			eCount++;
		}
		int wCount = 0;
		for(Coordinate c : walls) {
			String key = "wall" + Integer.toString(wCount+1);
			objects.put(key, new Enemy(walls[wCount]));
			grid[c.getX()][c.getY()] = key;
			wCount++;
		}
	}
	
	public String[][] printGrid() {
		String current;
		int height = grid[0].length;
		String[][] result = new String[grid.length][height];
		for (int x=0; x<grid.length; x++) {
			for (int y=0; y<height; y++) {
				current = grid[x][y];
				if(current == null || current == "") {
					result[x][y] = "_____";
				}
				else {
					result[x][y] = current;
				}
			}
		}
		return result;
	}
	
	public void playerMove(String dir) {
		int[] vector = new int[]{0,0};
		switch (dir) {
		case "w":
			vector[0] = -1;
			break;
		case "a":
			vector[1] = -1;
			break;
		case "s":
			vector[0] = 1;
			break;
		case "d":
			vector[1] = 1;
			break;
		default:
			break;
		}
		move(vector,"player");
	}
	
	public void move(int[] vector, String key) {
		grid[objects.get(key).getPosition().getX()][objects.get(key).getPosition().getY()] = "";
		objects.get(key).move(vector);
		grid[objects.get(key).getPosition().getX()][objects.get(key).getPosition().getY()] = key;
	}
}
