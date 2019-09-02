package lambda.app;

public class ATest {

	public static void main(String[] args) {
		B b = new A();
		b.tuenOn();
		
		B b1 = new B() {
			@Override
			public void tuenOn() {
				System.out.println("B1 ON");	
			}
		};
		b1.tuenOn();
		
		B b2 = () -> { System.out.println("B2 ON"); };
		
		b2.tuenOn();
		
	}

}
