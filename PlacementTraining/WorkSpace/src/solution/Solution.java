package solution;

import java.util.Arrays;

public class Solution {


	    public static long[] unmarkedSumArray(int[] nums, int[][] queries) {
	        int[] unSorted = Arrays.copyOf(nums, nums.length);
	        sort(nums, nums.length);

	        
    		System.out.println("nums => "+Arrays.toString(nums));

    		System.out.println("unSorted => "+Arrays.toString(unSorted));

	        long[] sums = new long[queries.length];
	        boolean[] marked = new boolean[nums.length];
	        int j =0,m = 0;
	        for (int i = 0; i < queries.length; i++) {
	            int index = queries[i][0];
	            int k = queries[i][1];

	            int count = 0;
	            long sum = 0;
	            
	            int val = unSorted[index];
	            int first = firstOcc(nums, val);
	            
	            nums[first] = 0;
	            
	            first--;
	            int cond = m+k;
	    		System.out.println(k+ " => "+Arrays.toString(nums));
	            while(count < k && m < nums.length){
	               
//	            	System.out.println("count = " + count + " k = " + k);
		    		System.out.println("m "+m+ " => "+Arrays.toString(nums) + "nums["+m+"] => " + nums[m]);
		    		if(nums[m] != 0) {
			            nums[m] = 0;
			            count++;  
		    		}
		    		m++;
   
	            }
	            sort(nums, nums.length);
	    		System.out.println(k+ " => "+Arrays.toString(nums));
	    		
	    		
	            for(int num:nums){
	                sum += (long)num;
	            }

	            sums[j++] = sum;
	            
	        }
	        return sums;
	    }

	    
	    //find the first occurance
	    static int firstOcc(int[] arr,int target){
	        int start = 0;
			int end = arr.length - 1;
			int res = -1;
			while(start <= end) {
				
				int mid = start + (end - start)/2;
				
				if(arr[mid] == target) {
					res = mid;
	                end = mid - 1;	
				}else if(target < arr[mid]) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}
			
			return res;
	    }
	    // sort the given array
	    static void sort(int[] arr, int n) {
	        for (int i = 0; i <= n - 2; i++) {
	            for (int j = i + 1; j > 0; j--) {
	                if (arr[j] < arr[j - 1]) {
	                    int temp = arr[j - 1];
	                    arr[j - 1] = arr[j];
	                    arr[j] = temp;
	                } else {
	                    break;
	                }
	            }
	        }
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,2,1,2,3,1};
		int[][] nums2 = {
				{1,2},
				{3,3},
				{4,2}
		};
		
//		System.out.println(Arrays.toString(intersect(nums1,nums2)));
		System.out.println(Arrays.toString(unmarkedSumArray(nums1,nums2)));
	}

}
