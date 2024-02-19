package rotationBinarySearch;

public class FindNumberOfRotation {
	
	//Method to find the pivot in the given array i.e., the largest element index
	public static int findPivot(int[] arr) {
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			
			//4 cases
			
			//Case 1: at only one point in the rotated array arr[mid] > arr[mid+1]
			if(mid < end && arr[mid] > arr[mid+1]) {
				return mid;
			}
			
			//{3,4,5,6,7,0,1,2}
			
			//Case 2: at only one point in the rotated array arr[mid - 1] > arr[mid]
			if(start < mid && arr[mid - 1] > arr[mid]) {
				return mid - 1;
			}
			
			//Remaining two cases
			if(arr[mid] <= arr[start]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		return -1;//i.e., there is no pivot means the given array is not rotated
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,4,5,6,7,0,1,2};
		int pivot =  findPivot(arr); 
			
		System.out.println(pivot + 1);
	}

}
