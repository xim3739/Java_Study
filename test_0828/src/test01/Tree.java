package test01;

public class Tree extends Bomb{

	public Tree() {
		super();
	}
	
	public static void sbomb() {
		System.out.println("Tree Static BOMB!!!!");
	}
	
	@Override
	public void bomb() {
		System.out.println("Tree BOMB!!!!!");
	}
}
