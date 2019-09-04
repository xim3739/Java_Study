package example13;

public class Example13_1 {

	public static void main(String[] args) {
		try {
			sub();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void sub() throws ArrayIndexOutOfBoundsException{
		int[] array = new int[10];
		int i = array[10];	
		throw new ArrayIndexOutOfBoundsException();	
	}
}
