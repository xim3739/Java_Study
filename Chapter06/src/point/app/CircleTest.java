package point.app;

public class CircleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point point = new Point(20, 30);
		Circle circle = new Circle(point, 50);
		
		System.out.println(point.toString());
		System.out.println(circle.toString());
	}

}
