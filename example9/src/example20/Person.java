package example20;

import java.util.Arrays;

public class Person implements Maxable, Comparable<Person>{
	private String name;
	private int height;
	
	public Person(String name, int height) {
		this.name = name;
		this.height = height;
	}
	
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + "]";
	}



	@Override
	public int compareTo(Person o) {
		if(this.height > o.height) {
			return 1;
		}else if(this.height == o.height) {
			return 0;
		} else {
			return -1;
		}
	}
	@Override
	public String getMaximum(Object[] arr) {
		Person[] compareObj = null;
		String result = null;
		int maxHeight = 0;
		if(arr instanceof Person[]) {
			compareObj = (Person[])arr;
		}
		maxHeight = this.height;
		for(int i = 0; i < compareObj.length; i++) {
			if(maxHeight > compareObj[i].height) {
				result = this.name;
			} else {
				result = compareObj[i].name;
				maxHeight = compareObj[i].height;
			}
			
		}
		
		return result;
	}
	
}
