package field_polymorphism.app;

public class HanTire extends Tire{ 
	
	public HanTire(String location, int maxRotation) {
		super(location, maxRotation);
	}

	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " HanTire life : " + (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.println(location + " HanTire is funk");
			return false;
		}
	}
}
