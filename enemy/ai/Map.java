package enemy.ai;

import enemy.ai.characters.Character;

public class Map {
	public Character[][] Grid;
	public Map(int width, int height){
		Grid = new Character[width][height];
	}
	
	public String[][] printGrid() {
		Character current;
		int height = Grid[0].length;
		String[][] result = new String[Grid.length][height];
		for (int x=0; x<Grid.length; x++) {
			for (int y=0; y<height; y++) {
				current = Grid[x][y];
				if(current == null) {
					result[x][y] = "Empty";
				}
			}
		}
		return result;
	}
}
