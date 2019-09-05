package example01.app;

public class ExampleTest {

	public static void main(String[] args) {
		int[] list = null;
		
		try {
			new ArrayIndexOutOfBoundsException();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

}
