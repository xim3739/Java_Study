package array_management;

public class KumTire extends Tire{
	public KumTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " KumTire life : " + (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.println(location + " KumTire is funk");
			return false;
		}
	}
}
