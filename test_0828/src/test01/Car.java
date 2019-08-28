package test01;

public class Car extends Bomb{

	public Car() {
		super();
	}
	
	public static void sbomb() {
		System.out.println("Car Static BOMB!!!!");
	}
	
	@Override
	public void bomb() {
		System.out.println("Car BOMB!!!!!");
	}
}
