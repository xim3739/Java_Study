package finalMethod;

public class Car {
	public int speed;
	
	public void speedUp() {
		speed += 1;
	}
	
	public final void stop() {
		System.out.println("Stop");
		speed = 0;
	}
}
