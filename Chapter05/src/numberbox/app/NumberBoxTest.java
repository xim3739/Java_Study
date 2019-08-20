package numberbox.app;

public class NumberBoxTest {

	public static void main(String[] args) {
		
		NumberBox num1 = new NumberBox();
		NumberBox num2 = new NumberBox(10, 10.0f, 10.0);
		NumberBox num3 = new NumberBox(20, 20.0f, 20.0, 'c');
		
		System.out.println(num1.toString());
		System.out.println(num2.toString());
		System.out.println(num3.toString());
		
		System.out.println(num3.toString());
		System.out.println(num3.calculate(10, 10.0f));
		
		System.out.println(num3.calculate(10, 10.0f, 10.0));
		System.out.println(num3.toString());

	}

}
