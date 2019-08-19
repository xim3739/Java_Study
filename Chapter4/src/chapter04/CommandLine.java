package chapter04;

public class CommandLine {

	public static void main(String[] args) {
		
		for(String value : args) {
			if(value.equals("-h")) {
				System.out.print("help \n");
			}else {
				System.out.print(value + " ");
			}
			
		}
		
		
	}

}
