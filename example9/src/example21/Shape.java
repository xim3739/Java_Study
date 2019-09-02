package example21;

public class Shape {
	private String color;
	
	public Shape() {
		super();
	}
	
	public void area() {
		System.out.println(this.color);
	}

	@Override
	public String toString() {
		return "Shape [color=" + color + "]";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
