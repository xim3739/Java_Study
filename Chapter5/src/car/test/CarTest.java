package car.test;

public class CarTest {

	public static void main(String[] args) {
		Car myCar = new Car(new String("Blue"), 0, 0);
		
		System.out.println("color is " + myCar.getColor());
		System.out.println("gear is " + myCar.getGear());
		System.out.println("speed is " + myCar.getSpeed());
		
		System.out.println(" ");
		
		myCar.setGear(4);
		System.out.println("change gear : " + myCar.getGear());
		
		myCar.setSpeed(80);
		System.out.println("speed : " +myCar.getSpeed());
		
		System.out.println("speed  : " + myCar.speedUp());
		System.out.println("speed  : " + myCar.speedUp());
		System.out.println("speed  : " + myCar.speedDown());
		
		System.out.println("");
		
		System.out.println("color is " + myCar.getColor());
		System.out.println("gear is " + myCar.getGear());
		System.out.println("speed is " + myCar.getSpeed());
		
		

	}

}
