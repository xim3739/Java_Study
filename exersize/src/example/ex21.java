package example;

public class ex21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0; int b = 0; int c = 0;
		
		for(a = 1; a <= 100; a++) {
			for(b = 1; b <= 100; b++) {
				for(c = 1; c <= 100; c++) {
					if((a<b) && (a*a + b*b == c*c)) {
						System.out.println(a+","+b+","+c);
					}
				}
			}
		}
	}

}
