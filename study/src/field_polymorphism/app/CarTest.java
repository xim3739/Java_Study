package field_polymorphism.app;

public class CarTest {

	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i = 1; i <= 5; i++) {
			int problemLocation = car.run();
			switch(problemLocation) {
				case 1:
					System.out.println("front Left Tire Change HanTire.");
					car.frontLeftTire = new HanTire("front Left",15);
					break;
				case 2:
					System.out.println("front Right Tire Change KumTire.");
					car.frontRightTire = new HanTire("front Right",13);
					break;
				case 3:
					System.out.println("back Left Tire Change HanTire.");
					car.backLeftTire = new HanTire("back Left",14);
					break;
				case 4:
					System.out.println("back Right Tire Change KumTire.");
					car.backRightTire = new HanTire("bakc Right", 17);
					break;
			}
			System.out.println("===========================");
		}
	}

}
