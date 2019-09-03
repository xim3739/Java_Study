package Example_14;

public class Ex_166 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("숫자들의 합 : " + sum(new int[] {1,2,3,4}));
	}
	
	public static int sum(int[] number) {
		int total = 0;
		for(int i = 0; i < number.length; i++) {
			total = total + number[i];
		}
		return total;
	}

}
