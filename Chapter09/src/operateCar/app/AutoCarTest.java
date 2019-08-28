package operateCar.app;

public class AutoCarTest {

	public static void main(String[] args) {
		
		OperateCar[] operate = {new AutoBus(), new AutoCar(), new AutoSubway()};
		
		for(int i = 0; i < operate.length; i++) {
			operate[i].start();
			operate[i].setSpeed(50);
			operate[i].turn(90);
			operate[i].stop();
			
		}
	}

}
