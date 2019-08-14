package Example_14;

public class Ex_160 {
	public static void main(String[] args) {
		int s[] = {12, 3, 19, 6, 18, 8, 12, 4, 1, 19};
		int min = 0;
		int max = 0;
		
		min = s[0];
		for(int i = 0; i < s.length; i++) {
			if(s[i] < min) {
				min = s[i];
			}
		}
		System.out.println("min is " + min);
		
		max = s[0];
		for(int i = 0; i < s.length; i++) {
			if(s[i] > min) {
				max = s[i];
			}
		}
	System.out.println("max is " + max);
	}
}
