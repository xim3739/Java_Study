package example08;

public class Cylinder extends Circle{
	private double height;
	
	public Cylinder() {
		super();
	}
	
	public Cylinder(double radius) {
		super(radius);
	}
	public Cylinder(double radius, double height) {
		super(radius);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getVolume() {
		return super.getArea() * this.height;
	}
	
}
