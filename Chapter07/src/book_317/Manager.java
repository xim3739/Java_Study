package book_317;

public class Manager extends Employee{
	private int bonus;

	public Manager(String name, String address, int salary, String rrn, int bonus) {
		super(name, address, salary, rrn);
		this.bonus = bonus;
	}
	
	public void test() {
		System.out.println("name : " + super.name);
		System.out.println("address : " + super.address);
		System.out.println("salary : " + super.salary);
		System.out.println("rrn : " + super.getRrn());
	}
	
	
}
