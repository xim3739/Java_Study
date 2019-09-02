package example21;

public class Triangle extends Shape{
	private int base;
	private int height;
	
	public Triangle(int base, int height) {
		this.base = base;
		this.height = height;
	}
	
	@Override
	public void area() {
		System.out.println(this.base * this.height);
	}

	@Override
	public String toString() {
		return "Triangle [base=" + base + ", height=" + height + "]";
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
