package parcticeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import insertionSort.InsertionSortAlgorithm;

public class Main {
    
	//LEETCODE 268
	public static int missingNumber(int[] arr) {

        //apply cyclic sort here 
		
		int n = arr.length, i = 0;
		while(i < n){
			System.out.println("At i = "+i+" : "+Arrays.toString(arr));
            if(arr[i] >= n){
                i++;
                continue;
            }

            if(arr[i] != i){
                swap(arr,i,arr[i]);
            }else{
                i++;
            }
        }
		
		int missing = -1 ;
		for(i = 0 ; i < n ; i++) {
			if(arr[i] != i) {
				return i;
			}
		}
		///System.out.println(Arrays.toString(a));
		
		return n;   
    }
	
	static void swap(int[] arr, int i , int j){

		int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	
	//LEETCODE 448
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        
    	//given the range [1,n]
    	int n = nums.length;
    	
    	List<Integer> disapperedList = new ArrayList<>();
    	/*
    	Set<Integer> set = new HashSet<>();
    	for(int num:nums) set.add(num);
    	
    	for(int i = 1 ; i <= n ; i++) {
    		if(!set.contains(i))
    			disapperedList.add(i);
    	}*/
    	//apply cyclic sort[1,n]
    	int i = 0;
    	while(i < n) {
    		int correct = nums[i]-1;
    		if(nums[i] != nums[correct]) {
    			swap(nums,i,correct);
    		}else {
    			i++;
    		}
    	}
    	System.out.println(Arrays.toString(nums));
    	
    	for(int j = 0 ; j < n ; j++){
    		
    		if(nums[j] != j + 1) {
    			disapperedList.add(j+1);
    		}
    	}
    	return disapperedList;
    }
    
    //LEETCODE 442
    public static List<Integer> findDuplicates(int[] nums) {
        
        //keyword ~ [1, n] nums[i]  range
        //So we can apply a cyclic sort for the array o(n)
        //then traverse the sorted array and add the element that are in wrong order
    	List<Integer> duplicates = new ArrayList<>();
    	
    	//apply cyclic sort
    	// here index = value - 1 { 0 = 1 -1} if it does not satisfy the condition swap it with its correct index else go to next index
    	int n = nums.length;
    	int i = 0;
    	
    	//{3,2,2}
    	while(i < n) {
    		
    		int correct = nums[i] - 1;
    		
    		if(nums[i] != nums[correct]) {
    			swap(nums, i, correct);
    		}else {
    			i++;
    		}
    	}
    	
    	for(i = 0 ; i < n ; i++) {
    		
    		if(nums[i] != i+1) {
    			duplicates.add(nums[i]);
    		}
    	}
    	return duplicates;
    }
    
    //LEETCODE 41. First Missing Positive
    public static int firstMissingPositive(int[] arr) {
    	
    	int n = arr.length;
    	InsertionSortAlgorithm.sort(arr, n);
    	int i = 1;
    	for( ; i <= arr[n - 1] ; i++) {
    		
    		if(!contains(arr,i)) {
    			return i;
    		}
    	}
    	return i;
    }
	static boolean contains(int[] arr, int k) {
		// TODO Auto-generated method stub
		for(int i: arr) {
			if(i == k) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7,8,9,11,12};
		
		System.out.println("Missing number:"+firstMissingPositive(arr));	
	}

}
