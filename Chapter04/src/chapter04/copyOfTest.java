package chapter04;

import java.util.Arrays;

public class copyOfTest {

	public static void main(String[] args) {
		
		int[] arr1 = new int[] {10,20,30,40,50};
		
		int [] arr2;
		
		for(int i : arr1) {
			System.out.print(i + " ");
		}
		
		System.out.println("");
		
		arr2 = Arrays.copyOf(arr1, arr1.length);
		
		for(int i : arr2) {
			System.out.print(i + " ");
		}
		
		System.out.println(" ");
		
		arr2 = arraysCopyOf(arr1);
		
		for(int i : arr2) {
			System.out.print(i + " ");
		}
		
	}
	
	public static int[] arraysCopyOf(int[] arr1) {
		int[] arr2 = new int[arr1.length];
		
		for(int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		
		return arr2;
	}

}
