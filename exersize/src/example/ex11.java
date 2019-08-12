package example;

public class ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		int sum = 0;
		
		for(i = 1; i <= 100; i++) {
			for(j = 0; j <= i; j++) {
				sum = j + sum;
			}
		}
		System.out.println(sum);
	}

}
