package book_341;

class Shape {
	protected int x,y;
	
	public void draw() {
		System.out.println("Shape Draw");
	}
}

class Rectangle extends Shape {
	private int width, height;
	
	@Override
	public void draw() {
		System.out.println("Rectangle Draw");
	}
}

class Triangle extends Shape {
	private int base, height;
	
	@Override
	public void draw() {
		System.out.println("Triangle Draw");
	}
}

class Circle extends Shape {
	private int radius;
	
	@Override
	public void draw() {
		System.out.println("Circle Draw");
	}
}

public class ShapeTest {

	public static void main(String[] args) {
		Shape s1, s2 ,s3 ,s4;
		
		s1 = new Shape();
		s2 = new Rectangle();
		s3 = new Triangle();
		s4 = new Circle();
		
		s1.draw();
		s2.draw();
		s3.draw();
		s4.draw();
	}

}
