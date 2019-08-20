package example03;

public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle() {
		this.width = 0;
		this.height = 0;
	}
	public Rectangle(int width, int heignt) {
		this.width = width;
		this.height = heignt;
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
	public int area() {
		return width * height;
	}
}
