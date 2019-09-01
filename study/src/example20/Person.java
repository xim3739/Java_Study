package example20;

public class Person implements Comparable{
	private String name;
	private int height;
	
	public Person(String name, int height) {
		this.name = name;
		this.height = height;
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
				result = compareObj[i].name;
				maxHeight = compareObj[i].height;
			} else {
				result = compareObj[i].name;
				maxHeight = compareObj[i].height;
			}
		}
		return result;
	}
	
}
