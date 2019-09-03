package example09;

public class Example09 {

	public static void main(String[] args) {
		try {
			someMethod();
			System.out.println("A");
		} catch (Exception e) {
			System.out.println("B");
		}finally {
			System.out.println("C");
		}
		System.out.println("D");
	}
	public static void someMethod() {
		
	}
}
