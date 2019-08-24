package Chapter03;

public class Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		
		for(i = 1; i < 6; i++) {
			for(j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
	}

}
