package example25;

public class Point {
	private int x;
	private int y;
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void print() {
		System.out.println("x is : " + this.x);
		System.out.println("y is : " + this.y);
	}
}
