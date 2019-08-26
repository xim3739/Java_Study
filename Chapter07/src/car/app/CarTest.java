package car.app;

public class CarTest {

	public static void main(String[] args) {
		SportsCar sc = new SportsCar(10);
		
		//sc.speed = 10; private 는 안된다. 
		//sc.setSpeed(20); 부모의 인스턴스 메소드 
		//sc.boolean = true; private 는 안된다.
		//sc.setTurbo(true); 
		
	}

}
