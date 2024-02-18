package LinearSearch;

import java.util.List;

public class LinearSearch {
	
	//Generic {array} type returns index
	public static <T> int search(T[] arr, T key ) {
		
		if(arr.length == 0)
			return -1;
		
		//LinearSearch Logic application
		for(int i = 0 ; i < arr.length ; i++ ) {
			
			if(arr[i] == key)
				return i;
		}	
		
		return -1;
	}
	
	//Generic {List} type returns index 
	public static <T> int searchList(List<T> arr, T key ) {
		
		if(arr.size() == 0)
			return -1;
		
		//LinearSearch Logic application
		for(int i = 0 ; i < arr.size() ; i++ ) {
			
			if(arr.get(i) == key)
				return i;
		}	
		
		return -1;
	}

	//Generic {array} type returns Boolean T or F
	public static <T> boolean searchBool(T[] arr, T key ) {
		
		if(arr.length == 0)
			return false;
		
		//LinearSearch Logic application
		for(int i = 0 ; i < arr.length ; i++ ) {
			
			if(arr[i] == key)
				return true;
		}	
		
		return false;
	}
	
	public static int[] searchIn2D(int[][] arr, int key) {
		
		for(int row = 0 ; row < arr.length ; row++ ) {
			
			for(int col = 0 ; col < arr[row].length ; col++ ) {
				
				if(arr[row][col] == key)
					return new int[] {row,col};
			}
		}
		
		
		return null;
	}
	
}
