package example12;

import java.util.ArrayList;

public class RandomList<T> {
	
	private ArrayList<T> arr;
	
	public RandomList() {
		arr = new ArrayList<T>();
	}
	
	public void add(T tiem) {
		arr.add(tiem);
	}
	
	public T ger() {
		return arr.get((int)(Math.random()*arr.size()));
	}
}
