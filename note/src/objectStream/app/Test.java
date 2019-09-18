package objectStream.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {
		
		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person("서울", "1991년", "심재현"));
		list.add(new Person("광주", "1995년", "김재현"));
		list.add(new Person("부산", "1996년", "최재현"));
		list.add(new Person("대구", "1912년", "홍길동"));
		list.add(new Person("제주도", "1944년", "이재현"));
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.bin"));
		
		objectOutputStream.writeObject(list);
		
		if(objectOutputStream != null) {
			objectOutputStream.close();
		}
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.bin"));
		ArrayList<Person> loadList = (ArrayList<Person>) objectInputStream.readObject();
		
		Iterator<Person> iter = loadList.iterator();
		
		//iterator
		Person data = null;
		while(iter.hasNext()) {
			data = iter.next();
			if(data.getName().equals("홍길동")) {
				System.out.println("찾았다. : " + data);
			} else {
				System.out.println(data);	
			}
		}
	
		//for
		for(int i = 0; i < loadList.size(); i++) {
			if(loadList.get(i).getName().equals("홍길동")) {
				System.out.println("찾았다. !!! : " + loadList.get(i));
				break;
			}
		}
		
		//foreach
		for(Person p : loadList) {
			if(p.getName().equals("홍길동")) {
				System.out.println("찾았다. : "+p);
			}
		}
		
	}

}
