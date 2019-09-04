package book_662;

public class GenericMethodTest {

	public static void main(String[] args) {
		Integer[] iArray = {10, 20, 30, 40};
		
		printArray(iArray);
	}
	
	public static <T> void printArray(T[] array) {
		for(T element : array) {
			System.out.println(element);
		}
		System.out.println("");
	}

}
