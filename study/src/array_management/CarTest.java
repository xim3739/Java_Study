package array_management;

public class CarTest {

	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i = 1; i <= 5; i++) {
			int problemLocation = car.run();
			if(problemLocation != 0) {
				System.out.println(car.tires[problemLocation-1].location + 
						"Change HanTire.");
				car.tires[problemLocation-1] = 
						new HanTire(car.tires[problemLocation-1].location, 15);
			}
			System.out.println("===========================");
		}
	}

}
