package example14;

import java.util.Calendar;

public class Example_06 {

	public static void main(String[] args) {
		Example_06_2 ex = new Example_06_1();
		
		Class<?> c1 = ex.getClass();
		
		System.out.println(c1.getSimpleName());
		System.out.println(c1.getName());
		
		//Calendar d = new Calendar();
		int i = new Integer(0);
		Integer a = 10;
		int s = Integer.parseInt("100");
		String str = new String("abc");
		
		System.out.println(i);
		System.out.println(a);
		System.out.println(s);
		System.out.println(str);
	}

}
