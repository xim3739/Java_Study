package example22;

public class Circle {
	public final static double PI = 3.141592;
	
	private double radius;
	private int cx;
	private int cy;
	
	public Circle() {
		this(0.0, 0, 0);
	}
	public Circle(double radius, int cx, int cy) {
		this.radius = radius;
		this.cx = cx;
		this.cy = cy;
	}
	
	public double area() {
		return this.radius * this.radius * PI;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public int getCx() {
		return cx;
	}
	public void setCx(int cx) {
		this.cx = cx;
	}
	public int getCy() {
		return cy;
	}
	public void setCy(int cy) {
		this.cy = cy;
	}
	
	
}
