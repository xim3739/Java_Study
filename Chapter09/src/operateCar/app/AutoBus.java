package operateCar.app;

public class AutoBus implements OperateCar{
	@Override
	public void start() {
		System.out.println("Bus Start.");
	}
	@Override
	public void setSpeed(int speed) {
		System.out.println("Bus speed : " + speed);
	}
	@Override
	public void turn(int degree) {
		System.out.println("Bus turn : " + degree);
	}
	@Override
	public void stop() {
		System.out.println("Bus Stop.");
	}
}
