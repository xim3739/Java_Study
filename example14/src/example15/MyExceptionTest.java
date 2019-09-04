package example15;

public class MyExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,20,30,40,50};
		int a = 11;
		int b = 30;
		
		searchArray(arr, a);
		searchArray(arr, b);
	}
	
	public static void searchArray(int[] arr, int a) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == a) {
				System.out.println("Find!!!");
				System.exit(0);
			} 
		}
		System.out.println(new MyException("NotFindException"));
	}
}
