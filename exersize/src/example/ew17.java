package example;

public class ew17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0; int y = 0; int z = 0;
		
		for(x = 0; x <= 10; x++) {
			for(y = 0; y <= 10; y++) {
				for(z = 0; z <= 10; z++) {
					if(x+y+z ==10) {
						System.out.println(x +","+y+","+z);
					}
				}
			}
		}

	}

}
