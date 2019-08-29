package example09;

public class PersonTest {

	public static void main(String[] args) {
		Person person1 = new Person();
		Customer person2 = new Customer("111-1111", 30, "seo", "seoul", "010-2222-2222");
		
		person1.setName("xim");
		person1.setAddress("seoul");
		person1.setPhoneNum("010-3333-3333");
		
		System.out.println(person1);
		System.out.println(person2);
		
	}

}
