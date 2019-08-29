package example10;

public class Shape {
	private int locationOfX;
	private int locationOfY;
	private String color;
	
	public Shape() {
		super();
	}
	
	public Shape(int locationOfX, int locationOfY, String color) {
		super();
		this.locationOfX = locationOfX;
		this.locationOfY = locationOfY;
		this.color = color;
	}

	public int getLocationOfX() {
		return locationOfX;
	}

	public void setLocationOfX(int locationOfX) {
		this.locationOfX = locationOfX;
	}

	public int getLocationOfY() {
		return locationOfY;
	}

	public void setLocationOfY(int locationOfY) {
		this.locationOfY = locationOfY;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Shape [locationOfX=" + locationOfX + ", locationOfY=" + locationOfY + ", color=" + color + "]";
	}
	
	
	
	
}
