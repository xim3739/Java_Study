package tryCatch.app;

public class BadIndex {
	
	public static final int NO;
	static {NO = 10;}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[NO];
		int result = 0;
		
		for(int i = 0; i < NO; i++) {
			array[i] = i;
			
		}
		try {		
			
			result = array[5];
		} catch (Exception e) {
			
			System.out.println("excemption : " + e.getMessage());
			result = array[9];
		} finally {
			
			System.out.println("END");
		}
		
		System.out.println("result : " + result);
	}

}
