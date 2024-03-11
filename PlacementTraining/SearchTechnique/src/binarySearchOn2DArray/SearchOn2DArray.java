package binarySearchOn2DArray;

import java.util.Arrays;

import binarySearch.BinarySearch;

public class SearchOn2DArray {

	static int[] rowColMatrix(int[][] arr,int target) {
		
		
		int low = 0 , high = arr.length -1;
		
		while(low < arr.length && high >= 0 ) {
			
			if(arr[low][high] == target) {
				
				return new int[] {low + 1,high + 1};
				
			}else if(arr[low][high] > target) {
				high--;
			}else {
				low++;
			}
		}
		
		return new int[2];
	}
	
	static int[] sortedArray(int[][] arr, int target) {
		
		int row = arr.length;
		int col = arr[0].length;
		
		if(row == 1) {
			return rangeSearch(arr, 0, 0, col, target);
		}
		
		int rStart  = 0;
		int rEnd = row - 1;
		int cMid = col / 2;
		
		while(rStart < (rEnd - 1)) {
			
			int mid = rStart + (rEnd - rStart)/2;
			
			if(arr[mid][cMid] == target) {
				return new int[] { mid, cMid};
			}
			
			if(arr[mid][cMid] < target) {
				rStart = mid;
			}else {
				rEnd = mid;
			}
		}
		
		//now at least two rows exists
		if(arr[rStart][cMid] == target) {
			return new int[] {rStart , cMid};
		}
		
		if(arr[rEnd][cMid] == target) {
			return new int[] {rEnd , cMid};
		}
		
		
		//Edge cases
		if(arr[rStart][cMid - 1] >= target) {
			return rangeSearch(arr, rStart, 0, cMid - 1, target);
		}
		
		if(arr[rStart][cMid + 1] <= target && arr[rStart][col -1] >= target) {
			return rangeSearch(arr, rStart, cMid + 1, col - 1, target);
		}
		
		if(arr[rEnd][cMid - 1] >= target) {
			return rangeSearch(arr, rEnd, 0, cMid - 1, target);
		}
	
		if(arr[rEnd][cMid + 1] <= target && arr[rEnd][col -1] >= target) {
			return rangeSearch(arr, rEnd, cMid + 1, col - 1, target);
		}
		
		return new int[] {-1,-1};
	}
	
	static int[] rangeSearch(int[][] arr,int row,int cStart,int cEnd,int target) {
   	 
		while (cStart <= cEnd) {
        
			int mid = cStart + (cEnd - cStart) / 2;
			
			System.out.println(arr[row][mid]);
            if (target < arr[row][mid]) {
            	cEnd = mid - 1;
            } else if (target > arr[row][mid]) {
            	cStart = mid + 1;
            }else {
                return new int[] {row,mid};
            }
        }
    	
    	return new int[2];
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {
				{1},

		};
		
	
		System.out.println(Arrays.toString(sortedArray(arr,1)));
		/*System.out.println(Arrays.toString(sortedArray(arr,2)));
		System.out.println(Arrays.toString(sortedArray(arr,3)));
		System.out.println(Arrays.toString(sortedArray(arr,4)));
		System.out.println(Arrays.toString(sortedArray(arr,5)));
		System.out.println(Arrays.toString(sortedArray(arr,6)));
		System.out.println(Arrays.toString(sortedArray(arr,7)));
		System.out.println(Arrays.toString(sortedArray(arr,8)));
		System.out.println(Arrays.toString(sortedArray(arr,9)));
		System.out.println(Arrays.toString(sortedArray(arr,10)));
		System.out.println(Arrays.toString(sortedArray(arr,11)));
		System.out.println(Arrays.toString(sortedArray(arr,12)));
		System.out.println(Arrays.toString(sortedArray(arr,13)));
		System.out.println(Arrays.toString(sortedArray(arr,14)));
		System.out.println(Arrays.toString(sortedArray(arr,15)));
		System.out.println(Arrays.toString(sortedArray(arr,16)));*/
	}

}
