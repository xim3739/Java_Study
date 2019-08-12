package example;

public class ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		while(i < 10) {
			System.out.println("i = " + i);
			i += 3;
		}
		
		int x = 0, y = 0;
		for(x = 0; x < 3; x++) {
			for(y = 2; y >= 0; y--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		int a = 0;
		int sum = 0;
		while(1 < 10) {
			sum += i++;
			if(i % 3 == 0) {
				continue;
			}
			System.out.println("i = " + i);
			if(sum > 10) {
				break;
			}
		}
	}

}
