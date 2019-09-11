package example08;
class Job extends Thread {
	
	private Thread name;
	
	public Job(String name) {
		this.name = new Thread(name);
	}
	
	@Override
	public void run() {
		System.out.println(name);
	}
	
	
}
public class Test {

	public static void main(String[] args) {
		Thread t1 = new Job("hi");
		Thread t2 = new Job("hello");
		
		t1.start();
		t2.start();

	}

}
