package example03.app;

public class Example03 {

	public static void main(String[] args) {
		try {
			int a = 10/0;
		} finally {
			System.out.println("끝");
		}
	}

}
