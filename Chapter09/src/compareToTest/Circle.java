package compareToTest;

public class Circle {
	public final double PI = 3.141592;
	public int radius;
	
	public Circle(int radius) {
		super();
		this.radius = radius;
	}
	
	public double getArea() {
		return PI * this.radius * this.radius;
	}

	@Override
	public String toString() {
		return "Circle [PI=" + PI + ", radius=" + radius + "]";
	}
	
	
	
}
