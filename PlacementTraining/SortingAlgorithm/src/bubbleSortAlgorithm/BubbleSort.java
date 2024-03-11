package bubbleSortAlgorithm;

import java.util.Arrays;

public class BubbleSort {

	static void sort(int[] arr) {
		
		int n =  arr.length;
		
		for(int i = 0 ; i < n ; i++) {
			
			int flag = 1;
			for(int j = 1 ; j < n - i ; j++) {
				
				if(arr[j - 1] > arr[j]) {
					flag = 0;
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
			
			if(flag == 1) {
				break;
			} 
			
			System.out.println(Arrays.toString(arr));
			//System.out.println("ELement at "+ (n-i) + " pos: "+arr[n-i-1]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {6,3,0,5};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
