package example22;

public class CircleTest {

	public static void main(String[] args) {
		Circle c1 = new Circle(12.4, 3, 4);
		
		System.out.println(c1.area());
		System.out.println("cx : " + c1.getCx());
		System.out.println("cy : " + c1.getCy());
	}

}
