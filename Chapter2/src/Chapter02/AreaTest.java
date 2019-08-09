package Chapter02;

public class AreaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double radius = 5.0;
		double pi = 3.141592;
		double area = 0.0;
		
		area = radius * radius * pi;
		
		System.out.println("area is " + area);
		System.out.println("radius is " + radius);
		System.out.printf("area is %f \nradius is %f", area, radius);
	}

}
