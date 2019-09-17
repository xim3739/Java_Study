package example06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Test {

	public static void main(String[] args) throws Exception {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Car_data.bin"));
		Car car1 = new Car("myCar", "11-7305", 50000000);
		Car car2 = new Car("myCar2", "11-22314", 30000000);
		Car car3 = new Car("myCar3", "11-918273", 20000000);
		
		objectOutputStream.writeObject(car1);
		objectOutputStream.writeObject(car2);
		objectOutputStream.writeObject(car3);
		
		System.out.println("완료");
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Car_data.bin"));
		ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream("Car_data_Copy.bin"));
		
		Car readCar1 = (Car)objectInputStream.readObject();
		Car readCar2 = (Car)objectInputStream.readObject();
		Car readCar3 = (Car)objectInputStream.readObject();
		
		System.out.println(readCar1);
		System.out.println(readCar2);
		System.out.println(readCar3);
		
		
	}

}
