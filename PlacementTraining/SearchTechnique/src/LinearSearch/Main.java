package LinearSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] arr1 = {43,235,123,63,78,123,45};
		
		 List<String> arr2 = new ArrayList<>(List.of("apple", "banana", "orange", "grape"));
		 
		 String[] arr3 = {"apple", "banana", "orange", "grape"};
		 
		 System.out.println(Arrays.toString(arr1)+"\nKey: 78\nIndex:"+LinearSearch.search(arr1, 78));
		 
		 System.out.println(arr2+"\nKey: banana\nIndex:"+LinearSearch.searchList(arr2, "banana"));
	 
		 System.out.println(Arrays.toString(arr3)+"\nKey: potato\nIndex:"+LinearSearch.search(arr3, "potato"));

	}

}
