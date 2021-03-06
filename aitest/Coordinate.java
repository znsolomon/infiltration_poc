package aitest;

public class Coordinate {
	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public Coordinate(int[] a) {
		this.setX(a[0]);
		this.setY(a[1]);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public int[] toArr() {
		return new int[] {this.x,this.y};
	}
}
