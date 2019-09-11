package chapter16.Bakery;

public class Guest extends Thread{
	private Bakery bakery;
	
	public Guest(Bakery bakery) {
		this.bakery = bakery;
	}
	
	@Override
	public void run() {
		
		for(int i = 1; i <= 10; i++) {
			bakery.getBread();
			
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}// end of for
	}// end of run
	
}
