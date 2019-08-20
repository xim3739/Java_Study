package box.test;

public class Box {
	private int width;
	private int length;
	private int height;
	private int boxArea;
	
	public Box() {
		this.width = 0;
		this.length = 0;
		this.height = 0;
		this.boxArea = 0;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int boxArea() {
		boxArea = width * length * height;
		return boxArea;
	}
}
