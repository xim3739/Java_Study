package example14;

import java.util.Calendar;

public class Example_03 {
	public static void main(String args[ ]) {
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, -1);
		
		System.out.println(cal.getTime());
	}
}
