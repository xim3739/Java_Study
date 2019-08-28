package test01;

public class House extends Bomb {
	public House() {
		super();
	}
	
	public static void sbomb() {
		System.out.println("HOUSE STATIC BOMB!!!!");
	}
	
	@Override
	public void bomb() {
		System.out.println("HOUSE BOMB!!!!!");
	}
}
