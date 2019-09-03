package Example_14;

public class Ex_163 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SIZE = 6;
		
		int[] count = new int[SIZE];
		
		for(int i = 0; i < 1000; i++) {
			++count[(int)(Math.random() * SIZE)];
		}
		
		System.out.println("====================");
		System.out.println("면      빈도");
		System.out.println("====================");
		
		for(int i = 0; i < count.length; i++) {
			System.out.println("" + (i+1) + "       " + count[i]);
		}
	}

}
