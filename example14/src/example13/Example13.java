package example13;

public class Example13 {

	public static void main(String[] args) {
		sub();
	}
	
	public static void sub() {
		int[] array = new int[10];
		try {
			int i = array[10];	
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		} finally {
			System.out.println("Function End");
		}
		
	}
}
