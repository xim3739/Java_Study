package example;

public class ex20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		int k = 0;
		int count = 0;
		
		for(i = 2; i <= 100; i++) {
			count = 0;
			for(k = 2; k < i; k++) {
				if(i % k == 0) {
					count = count + 1;
				}
			}
			if(count == 0) {
				System.out.printf("%d ",i);
			}
		}
	}

}
