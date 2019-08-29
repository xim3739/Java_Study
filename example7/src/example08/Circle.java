package example08;

public class Circle {
	
	private final double PI = 3.141592;
	
	private double radius;
	private String color;
	
	public Circle() {
		super();
	}
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getArea() {
		return PI * this.radius * this.radius;
	}
	
}
