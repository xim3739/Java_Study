package chapter16.Bakery;

public class BakeryTest {

	public static void main(String[] args) {
		Bakery bakery = new Bakery();
		
		Baker baker = new Baker(bakery);
		Guest guest = new Guest(bakery);
		
		baker.start();
		guest.start();
		
	}

}
