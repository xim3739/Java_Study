package example12;

public class SumTest {

	public static void main(String[] args) {
		Sum mySum = new Sum(10, 20);
		
		System.out.println(mySum.sum());
		
		System.out.println(mySum.sum(30));
	}

}
