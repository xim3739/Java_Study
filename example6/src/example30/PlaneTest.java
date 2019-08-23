package example30;

public class PlaneTest {

	public static void main(String[] args) {
		Plane plane1 = new Plane();
		System.out.println(plane1);
		
		Plane plane2 = new Plane("asiana", "A380", 600);
		System.out.println(plane2);
		
		System.out.println("planes count is " + Plane.getPlanes());
		
	}

}
