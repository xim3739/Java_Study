package maptest.app;

import java.util.HashMap;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
		
		HashMap<String, Student> myHash = new HashMap<String, Student>();
		myHash.put("1", new Student(10, "xim"));
		myHash.put("2", new Student(44, "seo"));
		myHash.put("3", new Student(22, "lee"));
		
		for(Entry<String, Student> myEntry : myHash.entrySet()) {
			String resultStr = myEntry.getKey();
			Student resultStd = myEntry.getValue();
			
			System.out.println("key : " + resultStr);
			System.out.println("value : " + resultStd);
		}
		
	}
}
