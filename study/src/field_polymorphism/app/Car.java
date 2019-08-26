package field_polymorphism.app;

public class Car {
	
	Tire frontLeftTire = new Tire("front Left", 6);
	Tire frontRightTire = new Tire("front Right", 2);
	Tire backLeftTire = new Tire("back Left", 3);
	Tire backRightTire = new Tire("bakc Right", 4);
	
	
	int run() {
		System.out.println("Car run.");
		if(frontLeftTire.roll() == false) {
			stop();
			return 1;
		}
		if(frontRightTire.roll() == false) {
			stop();
			return 2;
		}
		if(backLeftTire.roll() == false) {
			stop();
			return 3;
		}
		if(backRightTire.roll() == false) {
			stop();
			return 4;
		}
		return 0;
	}
	
	void stop() {
		System.out.println("Car stop.");
	}
}
