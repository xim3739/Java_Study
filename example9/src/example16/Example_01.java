package example16;


import java.util.Date;
import java.util.StringTokenizer;

public class Example_01 {
	public static void main(String args[ ]) {
		int randomValue = 0;
		randomValue = (int)(Math.random() * 100 + 1);
		System.out.println(randomValue);
		
		String str = "082-2-777-5666";
		StringTokenizer st = new StringTokenizer(str,"-");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		Date date = new Date();
		System.out.println(date);
		
		Example_01 ex = new Example_01();
		Class<?> c = ex.getClass();
		System.out.println(c);
		
		for(int i = 0; i < 90; i += 5) {
			System.out.println(i + "도 = " + Math.toRadians(i));
		}
	}
}
