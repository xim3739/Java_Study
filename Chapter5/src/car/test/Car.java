package car.test;

public class Car {
	
	private String color;
	private int gear;
	private int speed;
	
	public Car() {
		this.color = null;
		this.gear = 0;
		this.speed = 0;
	}
	
	public Car(String color, int gear, int speed) {
		this.color = color;
		this.gear = gear;
		this.speed = speed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getGear() {
		return gear;
	}

	public void setGear(int gear) {
		this.gear = gear;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int changeGear(int gear) {
		this.gear = gear;
		return this.gear;
	}
	
	public int speedUp() {
		this.speed = this.speed + 5;
		return this.speed;
	}
	
	public int speedDown() {
		this.speed = this.speed - 5;
		return this.speed;
	}
	
}
