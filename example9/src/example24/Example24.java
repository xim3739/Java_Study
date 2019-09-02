package example24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Example24 {

	public static void main(String[] args) {
		String str = null;
		
		Scanner input = new Scanner(System.in);
		System.out.print("input String : ");
		str = input.nextLine();
		
		StringTokenizer st = new StringTokenizer(str," ");
		int value = st.countTokens();
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println(value);
		
		String[ ] array = str.split(" ");
		Arrays.sort(array);
		System.out.println(Arrays.deepToString(array));
		
	}

}
