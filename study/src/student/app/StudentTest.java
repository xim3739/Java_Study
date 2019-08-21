package student.app;

public class StudentTest {

	public static void main(String[] args) {
		
		Student student1 = new Student();
		Student student2 = new Student("xim", 20101197, "man", 70);
		
		student1.setName("seo");
		student1.setStdNum(20151197);
		student1.setGender("man");
		student1.setScore(90);
		
		System.out.println("name : " + student1.getName());
		System.out.println("Student number : " + student1.getStdNum());
		System.out.println("gender : " + student1.getGender());
		System.out.println("score : " + student1.getScore());
		
		System.out.println(student2.toString());
		
		student1.nameScorePrint();
		student2.nameScorePrint();
	}

}
