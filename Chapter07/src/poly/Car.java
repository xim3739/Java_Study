package poly;

public class Car  extends Bomb{
	
	public Car() {
		super();
	}

	@Override
	public void bomb() {
		System.out.println("Cars BOMB!!!!!");
	}
	
	public static void sbomb() {
		System.out.println("Static Cars BOMB!!!!!!!");
	}
}
