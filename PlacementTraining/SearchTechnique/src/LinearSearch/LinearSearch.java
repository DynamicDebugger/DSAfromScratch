package LinearSearch;

import java.util.List;

public class LinearSearch {
	
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
	
	//List
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
}
