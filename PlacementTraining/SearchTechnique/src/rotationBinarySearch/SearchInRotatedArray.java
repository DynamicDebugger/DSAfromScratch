package rotationBinarySearch;

public class SearchInRotatedArray {

	//Approach-1: Find the pivot in the array(pivot ~ largest element) then apply binary search in both halves
	
	//Step-1 => Find the pivot i.e., by start > mid
	
	static int findPivot(int[] arr) {
		
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
			
			if(arr[mid] <= arr[start]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		return -1;
	}
	//Step-2: Apply binary search within given range
	static int binarySearch(int[] arr, int target, int start, int end) {
		
		while(start <= end) {
			
			int mid = start + (end -start)/2;
			
			if(target < arr[mid]) {
				end = mid - 1;
			}else if(target > arr[mid]) {
				start = mid + 1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}
	
	//search is initiated
    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return binarySearch(nums, target, 0 , nums.length - 1);
        }
        

        // if pivot is found, you have found 2 asc sorted arrays
        if (nums[pivot] == target) {
            return pivot;
        }

        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,4,5,6,7,0,1,2};
		int target = 2;
		
		System.out.println(search(arr,target));
		
	}

}
