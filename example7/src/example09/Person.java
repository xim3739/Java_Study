package example09;

public class Person {
	private String name;
	private String adress;
	private String phoneNum;
	
	public Person() {
		super();
	}
	public Person(String name, String adress, String phoneNum) {
		super();
		this.name = name;
		this.adress = adress;
		this.phoneNum = phoneNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return adress;
	}
	public void setAddress(String adress) {
		this.adress = adress;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", adress=" + adress + ", phoneNum=" + phoneNum + "]";
	}
	
	
	
}
