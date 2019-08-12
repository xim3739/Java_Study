package Chapter03;

public class OddOrEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 10; i++) {
			
			int num = (int) (Math.random()*10+1);
			
			evenOdd(num);
			
		}
		
	}
	
	public static void evenOdd(int num) {
		
		if(num % 2 == 1) {
			System.out.println(num + " is odd");
		} else {
			System.out.println(num + " is even");
		}
	}

}
