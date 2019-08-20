package example06;

public class RectangleTest {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(10,20);
		
		rectangle.setHeight(40);
		
		System.out.println("area is " + rectangle.area());
		System.out.println("perimeter is " + rectangle.perimeter());

	}

}
