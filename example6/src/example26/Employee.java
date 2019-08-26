package example26;

public class Employee {
	private String name;
	private String phoneNum;
	private int salary;
	
	public Employee() {
		this(null, null,0);
	}
	public Employee(String name, String phoneNum, int salary) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", phoneNum=" + phoneNum + ", salary=" + salary + "]";
	}
	
	
}
