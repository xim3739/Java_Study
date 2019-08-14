package Chapter03;

public class Pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		double sum = 0;
		boolean flag = false;
		for(i = 1; i <= 100000; i = i + 2) {
			if(flag == false) {
				sum = sum + (double)4/(double)i;
			} else {
				sum = sum - (double)4/(double)i;
			}
			flag = !flag;
		}
		
		System.out.println(sum);
	}

}
