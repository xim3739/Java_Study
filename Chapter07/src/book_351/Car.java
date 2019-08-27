package book_351;

public class Car {
	private String model;
	
	public Car(String model) {
		this.model = model;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Car) {
			return model.equals(((Car) obj).model);
		}
		else
			return false;
	}
}
