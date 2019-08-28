package test01;

public class Building extends Bomb{
	public Building() {
		super();
	}
	public static void sbomb() {
		System.out.println("Building Static BOMB!!!!!");
	}
	
	@Override
	public void bomb() {
		System.out.println("Building BOMB!!!!!!");
	}
}
