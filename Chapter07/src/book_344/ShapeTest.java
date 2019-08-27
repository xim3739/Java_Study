package book_344;

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
	public static void printLocation(Shape s) {
		System.out.println("x = " + s.x + "y = " + s.y);
	}
	public static void main(String[] args) {
		Rectangle s1 = new Rectangle();
		Triangle s2 = new Triangle();
		Circle s3 = new Circle();
		
		printLocation(s1);
		printLocation(s2);
		printLocation(s3);
	}

}
