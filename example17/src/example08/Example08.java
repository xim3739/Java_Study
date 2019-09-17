package example08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example08 {

	public static final Scanner SCAN = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		List<MyClass> list = new ArrayList<MyClass>();
		
		int no = 0;
		
		while (true) {
			System.out.print("input name : ");
			String name = SCAN.nextLine();
			System.out.print("intput number : ");
			String num = SCAN.nextLine();
			System.out.print("input E-mail : ");
			String eMail = SCAN.nextLine();
			list.add(new MyClass(no++, name, num, eMail));
			
			System.out.print("continue (y / n) : ");
			String con = SCAN.nextLine();
			if (con.equals("y") || con.equals("Y")) {
				continue;
			} else if (con.equals("n") || con.equals("N")) {
				break;
			}
		}

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("myClass.bin"));

		objectOutputStream.writeObject(list);

		objectOutputStream.close();

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("myClass.bin"));
		List<MyClass> list2 = (ArrayList<MyClass>) objectInputStream.readObject();

		boolean findFlag = false;

		while (true) {
			System.out.print("intput search number : ");
			String num = SCAN.nextLine();

			for (int i = 0; i < list2.size(); i++) {
				if (num.equals(list2.get(i).getNum())) {
					findFlag = true;
				}
				if (findFlag == true) {
					System.out.println(list2.get(i));
					break;
				}
			} // end of for

			if (findFlag == false) {
				System.out.println("not found try again");
				continue;
			}

			System.out.print("continue (y / n) : ");
			String con = SCAN.nextLine();
			if (con.equals("y") || con.equals("Y")) {
				break;
			} else if (con.equals("n") || con.equals("N")) {
				System.exit(0);
			}

		} // end of while

		objectInputStream.close();

	}

}
