package book_651.app;

public class BoxTest {

	public static void main(String[] args) {
		Box<String, Integer> box1 = new Box<String,Integer>("xim",20);
		String name = box1.getData();
		int num = box1.getData2();
		
		System.out.println(name + num);
		
//		Box<Integer> box2 = new Box<Integer>(100);
//		
//		int value = (int) box2.get();
//		
//		System.out.println(value);
//		
//		Box<MyData> box3 = new Box<MyData(new MyData("싸다김밥"));
//		MyData md = (MyData) box3.get();
//		System.out.println(md.str);
	}

}
