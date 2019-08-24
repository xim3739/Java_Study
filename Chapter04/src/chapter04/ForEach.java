package chapter04;

public class ForEach {
	
	private int[] numsArray;
	
	
	public ForEach() {
		this.numsArray = new int[] {10, 20, 30};
	}
	
	public ForEach(int[] numsArray) {
		this.numsArray = numsArray;
	}
	
	public void forPrint() {
		for(int i = 0; i < numsArray.length; i++) {
			System.out.print(numsArray[i] + " ");
		}
	}
	
	public void forEachPrint() {
		for(int num : numsArray) {
			System.out.print(num+" ");
		}
	}
	

	public int[] getNumsArray() {
		return numsArray;
	}
	

	public void setNumsArray(int[] numsArray) {
		this.numsArray = numsArray;
	}
	
}
