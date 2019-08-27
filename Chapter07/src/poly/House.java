package poly;

public class House extends Bomb{
	public House() {
		super();
	}
	
	@Override
	public void bomb() {
		System.out.println("Houses BOMB!!!!!");
	}
	
	public static void sbomb() {
		System.out.println("Static Houses BOMB!!!!!!!");
	}
}
