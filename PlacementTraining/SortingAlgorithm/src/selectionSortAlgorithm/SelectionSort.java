package selectionSortAlgorithm;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,3,0,5};
		sort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	static void sort(int[] arr, int n) {
		// TODO Auto-generated method stub
		//Selecting an element and fix at its correct index
		//Here we select the max element of the array and fix at its index
		//Then we will do next max element and repeat this until all element is selected
		for(int i = n - 1 ; i >= 0 ; i--) {
			
			int max = 0,index = 0;
			for(int j = 0 ; j <= i ; j++) {
				
				if(arr[j] > max) {
					max = arr[j];
					index = j;
				}
			}
			
			//now we found the max at this iteration
			//swap elements at arr[index] and arr[i]
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
			System.out.println(Arrays.toString(arr));
		}
	}

}
