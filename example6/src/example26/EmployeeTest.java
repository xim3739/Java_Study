package example26;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee ximEmp = new Employee("xim", "010-3583-3739", 5000000);
		Employee seoEmp = new Employee();
		
		seoEmp.setName("seo");
		seoEmp.setPhoneNum("010-3322-3314");
		seoEmp.setSalary(10000000);
		
		System.out.println(ximEmp);
		System.out.println(seoEmp);
	}

}
