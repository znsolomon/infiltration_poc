package aitest;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static Coordinate[] walls = new Coordinate[] {new Coordinate(1,2),new Coordinate(2,2),new Coordinate(3,2),
			new Coordinate(4,2),new Coordinate(5,2),new Coordinate(6,2),new Coordinate(1,5),new Coordinate(2,5),
			new Coordinate(3,5),new Coordinate(4,5),new Coordinate(5,5),new Coordinate(6,5)};
	public static boolean running;
	public static boolean pTurn;
	public static int pMoves;
	
	public static void main(String[] args) {
		running = true;
		pTurn = true;
		pMoves = 3;
		Scanner input = new Scanner(System.in);
		Map levelOne = new Map(8,8, new Coordinate(0,0), new Coordinate[] {new Coordinate(7,0), new Coordinate(7,7)}, walls);
		print2dArray(levelOne.getGrid());
		while (running) {
			System.out.println("Player turn");
			while(pTurn) {
				System.out.println("Moves left: " + Integer.toString(pMoves));
				System.out.println("Player move (WASD)");
				String move = input.nextLine();
				levelOne.playerMove(move);
				print2dArray(levelOne.getGrid());
				pMoves--;
				if(pMoves <= 0) {
					pTurn = false;
				}
			}
			System.out.println("Enemy turn");
			running = false;
		}
	}

	public static void print2dArray(String[][] output) {
		for (int i=0; i<output.length; i++) {
			System.out.println(Arrays.toString(output[i]));
		}
	}
}
