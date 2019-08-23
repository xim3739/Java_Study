package example31;

public class BoxTest {
	public static void main(String[] args) {
		Box box1 = new Box();
		System.out.println(box1);
		
		Box box2 = new Box(12, 33, 44, true);
		System.out.println(box2);
	}
}
