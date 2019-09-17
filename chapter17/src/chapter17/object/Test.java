package chapter17.object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) throws Exception {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student_class_data.bin"));
		
		Student student1 = new Student("xim", 12);
		
		objectOutputStream.writeObject(student1);
		
		objectOutputStream.close();
		
		System.out.println("완료");
		
		ObjectInputStream inputObjectInputStream = new ObjectInputStream(new FileInputStream("student_class_data.bin"));
		Student student2 = (Student)inputObjectInputStream.readObject();
		inputObjectInputStream.close();
		
		System.out.println("완료");
		
		System.out.println(student2);
	}

}
