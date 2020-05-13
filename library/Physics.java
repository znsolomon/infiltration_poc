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
}
