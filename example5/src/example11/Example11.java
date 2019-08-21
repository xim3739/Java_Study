package example11;

public class Example11 {

	public static void main(String[] args) {
		String x= "abc";
		
		String x1 = x.toUpperCase();
		
		String y = x1.replace('a', 'd');
		
		y = y + "xyz";
		
		System.out.println(y);

	}

}
