package poly;

public class Tree extends Bomb{

	public Tree() {
		super();
	}

	@Override
	public void bomb() {
		System.out.println("Tree BOMB!!!!!");
	}
	
	public static void sbomb() {
		System.out.println("Static Trees BOMB!!!!!!!");
	}
}
