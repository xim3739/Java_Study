package example19;

public class Cube {
	private double side;
	
	public Cube() {
		this(0.0);
	}
	public Cube(double side) {
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}
	public double getVolume() {
		return side*side*side;
	}
}
