package cyclicSortAlgorithm;

import java.util.Arrays;

public class CyclicSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,1,5};
//		sort(arr);
//		System.out.println(Arrays.toString(arr));
		CyclicSort csrt = new CyclicSort();
		System.out.println(csrt.missingNumber(arr, 5));
	}
	static void sort(int[] arr) {
		
		int i = 0;
		while(i < arr.length ) {
			
	        if (arr[i]-1 == i) {
	            //swap(arr, i, correct);
	        	i++;
	        } else {
	            //i++;
	        	swap(arr, i, arr[i] - 1);
	        }
		}
	}
	static void swap(int[] arr, int i, int j) {
		
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
    int missingNumber(int arr[], int n) {
        int i = 0;
        while (i < arr.length) {
            int crt = arr[i] - 1;
            if (arr[i] != arr[crt]) {
                swap(arr, i, crt);
            } else {
                i++;
            }
        }
        
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return arr[i];
            }
        }
        
        return -1;
    }
}

/**
 * 			int correct = arr[i] - 1;
	        if (arr[i] != arr[correct]) {
	            swap(arr, i, correct);
	        } else {
	            i++;
	        }
 */
