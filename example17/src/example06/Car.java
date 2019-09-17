package example06;

import java.io.Serializable;

public class Car implements Serializable, Comparable<Car>{
	public String name;
	public String num;
	public int price;
	
	public Car(String name, String num, int price) {
		super();
		this.name = name;
		this.num = num;
		this.price = price;
	}

	@Override
	public int compareTo(Car o) {
		if(this.price > o.price) {
			return 1;
		} else if(this.price < o.price) {
			return -1;
		} else {
			return 0;	
		}
	}
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", num=" + num + ", price=" + price + "]";
	}
	
	
}
