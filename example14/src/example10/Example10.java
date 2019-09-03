package example10;

public class Example10 {

	public static void main(String[] args) {
		try {
			int x = 0;
			int y = 5/x;
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception");
		}
		System.out.println("finished");
	}

}
