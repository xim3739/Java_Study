package car.app;

public class Car {
	private int speed;
	int dspeed;
	public static int myCar;
	
	public Car(int speed) {
		this.speed = speed;
		System.out.println("상위 객체");
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
