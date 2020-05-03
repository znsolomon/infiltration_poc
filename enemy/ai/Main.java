package enemy.ai;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Map levelOne = new Map(8,5);
		System.out.println(Arrays.deepToString(levelOne.printGrid()));
	}

}
