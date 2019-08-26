package array_management;

public class Car {
	Tire[] tires = {
			new Tire("front Left", 6),
			new Tire("front Right", 2),
			new Tire("back Left", 3),
			new Tire("bakc Right", 4),
	};
	
	int run() {
		System.out.println("Car run.");
		for(int i = 0; i < tires.length; i++) {
			if(tires[i].roll() == false) {
				stop();
				return (i +1);
			}
		}
		return 0;
	}
	
	void stop() {
		System.out.println("Car stop.");
	}
}
