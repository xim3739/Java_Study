package example21;

public class Ractangle extends Shape{
	private int length;
	private int width;
	
	public Ractangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	@Override
	public void area() {
		System.out.println(this.length * this.width);
	}

	@Override
	public String toString() {
		return "Ractangle [length=" + length + ", width=" + width + "]";
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	
}
