package book_342;

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
	private static Shape arrayOfShape[];
	
	public static void main(String args[]) {
		init();
		drawAll();
	}
	
	public static void init() {
		arrayOfShape = new Shape[3];
		arrayOfShape[0] = new Rectangle();
		arrayOfShape[1] = new Triangle();
		arrayOfShape[2] = new Circle();
	}
	
	public static void drawAll() {
		for(int i = 0; i < arrayOfShape.length; i++) {
			arrayOfShape[i].draw();
		}
	}
}
