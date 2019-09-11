package example17;

public class Student implements Comparable<Object>{
	private String name;
	private String address;
	private String phone;
	
	public Student(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	
	@Override
	public int compareTo(Object o) {
		Student st = null;
		if(o instanceof Student) {
			st = (Student)o;
		}
		
		int result = this.phone.compareTo(st.phone);
		
		return result;
		
	}
	
}
