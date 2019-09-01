package compareable.app;

public class RectangleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rec1 = new Rectangle(100, 20);
		Rectangle rec2 = new Rectangle(30, 40);
		int result = 0;
		
		System.out.println(rec1);
		System.out.println(rec2);
		
		result = rec1.compareTo(rec2);
		
		if(result == 1) {
			System.out.println("rec1 is bigger than rec2");
		} else if(result == -1) {
			System.out.println("rec1 is smaller than rec2");
		}else {
			System.out.println("rec1 , rec2 same");
		}
		
		}

}
