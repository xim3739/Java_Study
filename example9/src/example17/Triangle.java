package example17;

;

public class Triangle extends Shape implements Movable, Drawable{

	private int height;
	private int width;
	@Override
	public void move(int dx, int dy) {
		System.out.println("x : " + dx + " y : " + dy + " move");
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing");
	}
	
	public Triangle() {
		super();
	}
	
	public Triangle(int locationOfX, int locationOfY, String color, int height, int width) {
		super(locationOfX, locationOfY, color);
		this.height = height;
		this.width = width;
	}
	
	public double getArea() {
		return (double)this.height * (double)this.width * 0.5;
	}
	
	public int getVolume() {
		return this.height + this.width;
	}

	@Override
	public String toString() {
		return "Triangle [height=" + height + ", width=" + width + ", getLocationOfX()=" + getLocationOfX()
				+ ", getLocationOfY()=" + getLocationOfY() + ", getColor()=" + getColor() + "]";
	}
	
	
	
}
