package aitest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import aitest.FindPlayer.Detect;
import aitest.actors.*;
import library.Physics;

public class Map {
	public HashMap<String,Actor> objects = new HashMap<String,Actor>();
	public static final String empty = "_____";
	public ArrayList<String> eKeys = new ArrayList<String>();
	public ArrayList<int[]> pVisited = new ArrayList<int[]>();
	public ArrayList<int[]> pVisitedOld = new ArrayList<int[]>();
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
			objects.put(key, new Enemy(e[eCount],key,0));
			grid[c.getX()][c.getY()] = key;
			eKeys.add(key);
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
		Coordinate pos = objects.get("player").getPosition();
		pVisited.add(new int[] {pos.getX(),pos.getY()});
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

	public void moveEnemies() {
		//Figure out a target for each of the enemies
		for(String key : eKeys) {
			//Get a list of each square the enemies can see
			Coordinate pos = objects.get(key).getPosition();
			int[] posArr = new int[] {pos.getX(),pos.getY()};
			HashMap<int[], String> fov = new HashMap<int[], String>();
			ArrayList<FindPlayer> important = new ArrayList<FindPlayer>();
			Boolean foundPlayer = false;
			Boolean foundLast = false;
			//Check each direction in turn
			fov.putAll(look(pos,true,-1));
			fov.putAll(look(pos,false,-1));
			fov.putAll(look(pos,true,1));
			fov.putAll(look(pos,false,1));
			for(int[] location : fov.keySet()) {
				Coordinate loc = new Coordinate(location);
				if (fov.get(location) == "Player") {//Target the player directly if they can see it
					important.add(new FindPlayer(Detect.PLAYER,Physics.calcDistance(location, posArr),loc));
					foundPlayer = true;
					//Remove the lesser locations if a higher has been found
					//Order goes: Location from last turn -> Location from this turn -> Player's location
					important.removeIf(find -> find.getDetect() != Detect.PLAYER);
					System.out.println("Player");
				}
				else if(check2by1Arr(pVisited,location) && foundPlayer == false) {//Target the places the player moved this turn
					important.add(new FindPlayer(Detect.TURN1,Physics.calcDistance(location,posArr),loc));
					foundLast = true;
					//Remove the lesser locations if a higher has been found
					//Order goes: Location from last turn -> Location from this turn -> Player's location
					important.removeIf(find -> find.getDetect() == Detect.TURN2);
				}
				else if(check2by1Arr(pVisitedOld,location) && foundLast == false) {
					important.add(new FindPlayer(Detect.TURN2,Physics.calcDistance(location,posArr),loc));
				}
			}
			//Get target based on which remaining location is closest
			double highDistance = 100;
			for (FindPlayer find : important) {
				if (find.getDistance() < highDistance) {
					((Enemy) objects.get(key)).setTarget(find.getLocation());
					highDistance = find.getDistance();
				}
			}
			//If no target is found, enemy will not move
			if(((Enemy) objects.get(key)).getTarget() == null) {
				((Enemy) objects.get(key)).setTarget(objects.get(key).getPosition());
			}
			System.out.println(Arrays.toString(((Enemy) objects.get(key)).getTarget().toArr()));
		}
	}
	
	public HashMap<int[], String> look(Coordinate pos, boolean axis, int dir){
		HashMap<int[], String> seen = new HashMap<int[], String>();
		if(axis) { //X axis if true, y axis if false
			for (int i=pos.getX(); i < grid.length && i > -1; i+=dir) {
				String current = grid[i][pos.getY()];
				if (current.contains("Wall")) {
					break;
				}
				else {
					seen.put(new int[] {i, pos.getY()},current);
				}
			}
		}
		else {
			for (int i=pos.getY(); i < grid[0].length && i > -1; i+=dir) {
				String current = grid[pos.getX()][i];
				if (current.contains("Wall")) {
					break;
				}
				else {
					seen.put(new int[] {pos.getX(), i},current);
				}
			}
		}
		return seen;
	}
	
	/**
	 * Checks an arraylist for a target array. Only works on 2x1 arrays
	 * @param list The list to be checked
	 * @param check The array being checked against the list
	 * @return True if 'list' contains 'check', false otherwise
	 */
	public boolean check2by1Arr(ArrayList<int[]> list, int[] check) {
		for(int[] item : list) {
			if (item[0] == check[0] && item[1] == check[1]) {
				return true;
			}
		}
		return false;
	}
	
	public String[][] getGrid(){
		return grid;
	}
}
