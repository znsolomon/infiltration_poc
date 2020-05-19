package library;

public class Physics {
	public static int[] addVectors(int[] one, int[] two){
		if(one.length > 2 || two.length > 2) {
			return null;
		}
		else {
			return new int[] {one[0]+two[0],two[1]+one[1]};
		}
	}
	/**
	 * Calculates the distance between coordinates 'one' and 'two' using pythagoras
	 * @param one
	 * @param two
	 * @return
	 */
	public static double calcDistance(int[] one, int[] two) {
		return Math.sqrt(Math.pow((one[0] - two[0]),2) + Math.pow((one[1] - two[1]),2));
	}
}
