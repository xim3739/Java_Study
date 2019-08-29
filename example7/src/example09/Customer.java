package example09;

public class Customer extends Person{
	private String customNum;
	private int mileage;
	
	public Customer() {
		super();
	}

	public Customer(String customNum, int mileage, String name, String adress, String phoneNum) {
		super(name, adress, phoneNum);
		this.customNum = customNum;
		this.mileage = mileage;
	}

	public String getCustomNum() {
		return customNum;
	}

	public void setCustomNum(String customNum) {
		this.customNum = customNum;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "Customer [customNum=" + customNum + ", mileage=" + mileage + ", toString()=" + super.toString() + "]";
	}

	
	
}
