package Example_14;

public class Book {
	
	public static void main(String[] args) {
	
		Booking booking = new Booking(0);
		
		booking.initArrayValue();
		
		while(true) {
		
			booking.display();
			booking.inputBookIndex();
			booking.retryBook();
			
		}
		
	}
	
}
