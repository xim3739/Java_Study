package point.app;

public class Circle {
	private Point point;
	private int radius;
	
	public Circle() {
		this(null,0);
	}
	
	public Circle(Point point, int radius) {
		this.point = point;
		this.radius = radius;
	}

	@Override
	public String toString() {
		return String.format("radius = %3d, %15s", this.radius, this.point);
	}
	
	
}
