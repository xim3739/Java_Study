package field_polymorphism.app;

public class Tire {
	public int maxRotation;//최대 회전수 (교체)
	public int accumulatedRotation;//회전수 누적
	public String location; //타이어의 위치
	
	public Tire(String location, int maxRoatation) {
		this.location = location;
		this.maxRotation = maxRoatation;
	}
	
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " Tire life : " + (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.println(location + " Tire is funk");
			return false;
		}
	}
}
