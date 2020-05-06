package aitest;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Map levelOne = new Map(8,8, new Coordinate(0,0), );
		print2dArray(levelOne.printGrid());
	}

	public static void print2dArray(String[][] output) {
		for (int i=0; i<output.length; i++) {
			System.out.println(Arrays.toString(output[i]));
		}
	}
}
