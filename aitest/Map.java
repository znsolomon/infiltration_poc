package aitest;

import java.util.HashMap;

import aitest.actors.*;
import library.Physics;

public class Map {
	public HashMap<String,Actor> objects = new HashMap<String,Actor>();
	public static final String empty = "_____";
	public String[][] grid;
	public Map(int width, int height, Coordinate p, Coordinate[] e, Coordinate[] walls){
		grid = new String[width][height];
		for(int w=0; w<width; w++) {
			for(int h=0; h<height; h++) {
				grid[w][h] = empty;
			}
		}
		objects.put("player", new Player(p));
		grid[p.getX()][p.getY()] = "Player";
		int eCount = 0;
		for(Coordinate c : e) {
			String key = "Enemy" + Integer.toString(eCount+1);
			objects.put(key, new Enemy(e[eCount],key));
			grid[c.getX()][c.getY()] = key;
			eCount++;
		}
		int wCount = 0;
		for(Coordinate c : walls) {
			String key = "Wall" + Integer.toString(wCount+1);
			objects.put(key, new Wall(walls[wCount]));
			grid[c.getX()][c.getY()] = key;
			wCount++;
		}
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
		Coordinate old = objects.get(key).getPosition();
		int[] n = Physics.addVectors(old.toArr(),vector);
		if(n[0] >= 0 && n[0] < grid.length && n[1] >= 0 && n[1] < grid[0].length && grid[n[0]][n[1]] == empty) {
			grid[old.getX()][old.getY()] = empty;
			objects.get(key).move(vector);
			grid[objects.get(key).getPosition().getX()][objects.get(key).getPosition().getY()] = objects.get(key).getName();
		}
		else {
			System.out.println("Invalid move");
		}
	}
	
	public String[][] getGrid(){
		return grid;
	}
}
