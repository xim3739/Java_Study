package example06;

public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle() {
		this.height = 0;
		this.width = 0;
	}
	public Rectangle(int width, int height) {
		this.height = height;
		this.width = width;
	}
	
	public int area() {
		return height * width;
	}
	public int perimeter() {
		return height * 2 + width * 2;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
