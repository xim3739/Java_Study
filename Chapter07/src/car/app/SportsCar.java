package car.app;

public class SportsCar extends Car {

	private boolean turbo;
	int dspeed;
	
	public SportsCar(int speed) {
		super(speed);
		System.out.println("하위 객체");
	}
	
	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
		Car.myCar = 10;
		
	}
	
}
