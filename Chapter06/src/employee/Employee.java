package employee;

public class Employee {
	private static int count = 0;
	
	private double salaray;
	private String name;
	
	public Employee() {
		this(0.0,null);
	}
	public Employee(double salary, String name) {
		this.salaray = salary;
		this.name = name;
		Employee.count++;
	}
	
	protected void finalize() throws Throwable {
		System.out.println("잘쓰세요.");
		Employee.count--;
	}
}
