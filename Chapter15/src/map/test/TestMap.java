package map.test;

import java.util.HashMap;
import java.util.Map.Entry;

public class TestMap {

	public static void main(String[] args) {
		HashMap<String, Student> hashMap = new HashMap<String, Student>();
		
		hashMap.put("number 1", new Student(1, "xim"));
		hashMap.put("number 2", new Student(2, "seo"));
		hashMap.put("number 3", new Student(3, "kim"));
		
		System.out.println(hashMap);
		
		hashMap.remove("number 1");
		System.out.println(hashMap);
		
		hashMap.put("number 3", new Student(4, "choi"));
		System.out.println(hashMap);
		
		for(Entry<String, Student> hs : hashMap.entrySet()) {
			String key = hs.getKey();
			Student value = hs.getValue();
			
			System.out.println("key : " + key);
			System.out.println("value : " + value);
		}
	}

}
