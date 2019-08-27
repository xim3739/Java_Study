package book_351;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car firstCar = new Car("HMW520");
		Car secondCar = new Car("HMW520");
		
		if(firstCar.equals(secondCar)) {
			System.out.println("equals Car");
		} else {
			System.out.println("not equals Car");
		}
	}

}
