package Chapter02;

public class Hello2 {

	public static void main(String[] args) {
		
		for(int i = 0; i < 4; i++ ) {
			for(int j = 0; j < 3 - i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j  <  i  + 1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for(int i = 5; i > 0; i-- ) {
			for(int j = (5-i); j >0; j--) {
				System.out.print(" ");
			}
			for(int j = 0; j  <  i-1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}

}
