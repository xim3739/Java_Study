package chapter16.Bakery;

public class Baker extends Thread{
	private Bakery bakery;
	
	public Baker(Bakery bakery) {
		this.bakery = bakery;
	}
	
	@Override
	public void run() {
		
		for(int i = 1; i <= 10; i++) {
			bakery.setBread();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}//end of for
	}//end of run
	
}
