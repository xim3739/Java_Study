package example06;

public class RectangleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rec = new Rectangle();
		
		rec.setDimensions(10, 20);
		rec.draw();
		System.out.println("Area is " + rec.getArea());
	}

}
