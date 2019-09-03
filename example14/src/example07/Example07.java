package example07;

public class Example07 {

	public static void main(String[] args) {
		try {
			int[] array = new int[-10];
			System.out.println("try");
		} catch (NegativeArraySizeException e) {
			System.out.println("Negative Array Size Exception");
		} catch (NumberFormatException e) {
			System.out.println("Number Format Exception");
		}  catch (Exception e) {
			System.out.println("Exception");
		}
	}

}
