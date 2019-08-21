package example13;

public class SumTest {

	public static void main(String[] args) {
		Sum mySum = new Sum(10.0, 20.0);
		
		System.out.println(mySum.sum());
		
		System.out.println(mySum.sum(40.0));
	}

}
