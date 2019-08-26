package book_326;

class Shape {
	public Shape() {
		System.out.println("Shape()");
	}
}

class Rectangle extends Shape {
	public Rectangle() {
		super();
		System.out.println("Rectangle()");
	}
}

public class Test {

	public static void main(String[] args) {
		Rectangle t = new Rectangle();
		
	}

}
