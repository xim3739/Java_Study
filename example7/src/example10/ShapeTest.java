package example10;

public class ShapeTest {

	public static void main(String[] args) {
		Triangle triangle = new Triangle(3,4,"red",3,10);
		
		System.out.println("Triangle Area is " + triangle.getArea());
		System.out.println("Triangle Volume is " + triangle.getVolume());
		System.out.println(triangle);
		
	}

}
