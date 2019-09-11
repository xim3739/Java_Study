package example17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentTest {

	public static void main(String[] args) {
		List<Student> student = new ArrayList<Student>();
		
		System.out.println("===추가====");
		addStudent(student, new Student("xim", "seoul", "010-1000-1100"));
		addStudent(student, new Student("seo", "seoul", "010-1233-3323"));
		addStudent(student, new Student("kim", "seoul", "010-1231-6464"));
		
		System.out.println("===삭제===");
		removeStudent(student, 0);
		
		System.out.println("===검색===");
		searchStudent(student,1);
		
		System.out.println("===출력===");
		print(student);
	}
	
	private static void removeStudent(List<Student> arr, int index) {
		
		try {
			if(arr.size() >= index) {
				System.out.println(arr.get(index) + "삭제 했습니다.");
				arr.remove(arr.get(index));
			} else {
				System.out.println("정보를 찾을 수 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("정보를 찾을 수 없습니다.");
		}
		
	}
	
	public static void searchStudent(List<Student> student, int index) {
		try {
			if(student.size() >= index) {
				System.out.println(student.get(index) + "검색 했습니다.");	
			} else {
				System.out.println("정보를 찾을 수 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("정보를 찾을 수 없습니다.");
		}
	
	}

	public static void addStudent(List<Student> arr, Student student2) {
		arr.add(student2);
		System.out.println(student2 + "추가 했습니다.");
	}
	
	public static void print(List<Student> student) {
		Iterator<Student> iter = student.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	

}
