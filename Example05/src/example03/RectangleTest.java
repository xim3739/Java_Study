package example03;

public class RectangleTest {

	public static void main(String[] args) {
		
		Rectangle myRect = new Rectangle();
		
		myRect.setWidth(10);
		myRect.setHeight(20);
		
		System.out.println("area is " + myRect.area());
	}

}
