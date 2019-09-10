package chapter16.Bakery;

public class Bakery {
	private static int num;
	private String[] bread = {"소보루 빵", "크림빵", "단팥빵", "슈크림빵", "식빵", "죽빵", "선빵"};
	private boolean isBread = false;
	
	public synchronized String getBread() {
		
		while(!isBread) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(num == 5 || num == 6) {
			System.out.println(this.bread[num] + "을 맞았습니다.");
		} else {
			System.out.println(this.bread[num] +"를 먹었습니다.");
		}
		isBread = false;
		notifyAll();
		
		return this.bread[num];
	}
	
	public synchronized void setBread() {

		while(isBread) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		num = (int)(Math.random()*6);
		
		if(num == 5 || num == 6) {
			System.out.println(this.bread[num] + "을 날렸습니다.");
		} else {
			System.out.println(this.bread[num] + "을 만들었습니다. ");
		}
		
		isBread = true;
		
		notifyAll();
	}

}
