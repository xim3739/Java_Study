package maptest.app;

public class Student implements Comparable<Student>{
	public int num;
	public String name;
	
	public Student(int num, String name) {
		this.num = num;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + "]";
	}
	
	@Override
	public int compareTo(Student o) {
		if (this.num > o.num) {
			return 1;
		} else if(this.num < o.num) {
			return -1;
		} else {
			return 0;		
		}
	
	}
}
