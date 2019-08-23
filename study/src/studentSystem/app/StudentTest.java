package studentSystem.app;

public class StudentTest {

	public static void main(String[] args) {
		
		Student student = new Student(20);
		
		student.inputScore();
		student.printArray();
		student.sumValue();
		student.avgValue();
		student.getMax();
		student.getMin();
		
		System.out.println(student);

	}
	
}
