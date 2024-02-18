package rotationBinarySearch;

public class SearchInRotatedArrayWithDuplicates {
    public static boolean search(int[] nums, int target) {
		int pivot = findPivotWithDuplicate(nums);
		
        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return binarySearch(nums, target, 0 , nums.length - 1);
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if (nums[pivot] == target) {
            return true;
        }

        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }
    //find pivot with duplicate elements
    static int findPivotWithDuplicate(int[] arr) {
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end) {
			
			int mid = start + (end - start)/2;
			
			//4 Cases
			if(mid < end && arr[mid] > arr[mid+1]) {
				return mid;
			}
			
			if(mid > start && arr[mid] < arr[mid-1]) {
				return mid-1;
			}
			
			//mid,start and end are equal ignore then skip duplicates
			if(arr[start] == arr[mid] || arr[mid] == arr[end]) {
				//skip the duplicates
				//NOTE when the start or end is pivot
				
				//check if start is pivot				
				if(arr[start] > arr[start+1]) {
					return start;
				}
				start++;
				
				//check if end is pivot
				if(arr[end] > arr[end-1]) {
					return end;
				}
				end--;
				
			}
			//left side is sorted so pivot should be right
			else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
				start = mid+1;
			}else {
				end = mid - 1;
			}
		}
		
		return -1;
	}
    
    
    //Step-2: Apply binary search within given range
	static boolean binarySearch(int[] arr, int target, int start, int end) {
		
		while(start <= end) {
			
			int mid = start + (end -start)/2;
			
			if(target < arr[mid]) {
				end = mid - 1;
			}else if(target > arr[mid]) {
				start = mid + 1;
			}else {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,9,2,2,2};
		int target = 9;
		System.out.println(search(arr, target));
		
	}

}
