package example08;

public class CircleTest {

	public static void main(String[] args) {
		Circle cir1 = new Circle(3.0);
		Cylinder cyl1 = new Cylinder(3.0, 10.0);
		
		System.out.println("circle Area is "+cyl1.getArea());
		System.out.println("cylinder volume is "+cyl1.getVolume());
		System.out.println("radius is " + cyl1.getRadius());
	}

}
