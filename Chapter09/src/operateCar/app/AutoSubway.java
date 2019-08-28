package operateCar.app;

public class AutoSubway implements OperateCar{
	@Override
	public void start() {
		System.out.println("Subway Start.");
	}
	@Override
	public void setSpeed(int speed) {
		System.out.println("Subway speed : " + speed);
	}
	@Override
	public void turn(int degree) {
		System.out.println("Subway turn : " + degree);
	}
	@Override
	public void stop() {
		System.out.println("Subway Stop.");
	}
}
