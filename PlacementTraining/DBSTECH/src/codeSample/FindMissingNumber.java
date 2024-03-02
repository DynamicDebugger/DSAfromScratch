package codeSample;

public class FindMissingNumber {

	static int findNumber(int[] arr,int n) {
		
		//formula for sum of n natural number
		int sN = (n*(n + 1)) / 2;
		
		int sum = 0;
		for(int num:arr) {
			sum += num;
		}
		
		return sN - sum;
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 5};
		System.out.println(findNumber(arr,arr.length+1));
	}
}
