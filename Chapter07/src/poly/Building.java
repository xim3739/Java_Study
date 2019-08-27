package poly;

public class Building extends Bomb{
	
	public Building() {
		super();
	}

	@Override
	public void bomb() {
		System.out.println("Buildings BOMB!!!!!");
	}
	
	public static void sbomb() {
		System.out.println("Static Buildings BOMB!!!!!!!");
	}
}
