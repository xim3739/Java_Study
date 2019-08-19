package box.test;

public class BoxTest {

	public static void main(String[] args) {
		
		Box box = new Box();
		
		box.setWidth(20);
		box.setLength(20);
		box.setHeight(30);
		
		System.out.println("width is " + box.getWidth());
		System.out.println("lengh is " + box.getLength());
		System.out.println("height is " + box.getHeight());
		System.out.println("box Area is " + box.boxArea());
	}

}
