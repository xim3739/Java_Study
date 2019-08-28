package operateCar.app;

public class AutoCar implements OperateCar{
	@Override
	public void start() {
		System.out.println("Car Start.");
	}
	@Override
	public void setSpeed(int speed) {
		System.out.println("Car speed : " + speed);
	}
	@Override
	public void turn(int degree) {
		System.out.println("Car turn : " + degree);
	}
	@Override
	public void stop() {
		System.out.println("Car Stop.");
	}
}
