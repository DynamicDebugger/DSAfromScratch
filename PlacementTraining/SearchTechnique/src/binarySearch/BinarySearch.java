package binarySearch;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	

	//For both ascending and descending order
	public static int Search(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1 ;
		int[] result = {-1,-1};
		//Check the order
		boolean isAsc = arr[0] < arr[arr.length - 1] ? true : false;
		
		while(start <= end) {
			
			int mid = start + (end - start) / 2;
			
			if(arr[mid] == key) {
				return arr[mid];
				
			}
			
			if(isAsc) {
				if(key > arr[mid]) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
			}else {
				if(key < arr[mid]) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
			}
			
		}


		return -1;
	}
	
	// Find First and Last Position of Element in Sorted Array
	public static int[] firstAndLastOcc (int[] arr, int target) {

		int[] res = new int[2];
		
		res[0] = multiOcc(arr,target,true);
		res[1] = multiOcc(arr,target,false);
		
		return res;
	}
	//First occ and last occ
    static int multiOcc(int[] arr,int target,boolean firstOcc){
        int start = 0;
		int end = arr.length - 1;
		int res = -1;
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			
			if(arr[mid] == target) {
				res = mid;
				if(firstOcc)
					end = mid - 1;
				else
					start = mid + 1;
				
			}else if(target < arr[mid]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		return res;
    }
    
    
    //Infinite array ~ Size of the array is unknown
    public static int infiniteArray(int[] arr , int target) {
    	
    	int start = 0 ,end = 1;
    	
        while(target > arr[end]) {
        	int temp = end + 1;
        	end = end + (end - start + 1) * 2;
        	start = temp;
        }
       return infiniteSearch(arr,start,end,target);
    }
    
    //binary search with start and or between range
    public static int infiniteSearch(int[] arr,int start,int end,int target) {
    	 while (start <= end) {
             int mid = start + (end - start) / 2;

             if (target < arr[mid]) {
                 end = mid - 1;
             } else if (target > arr[mid]) {
                 start = mid + 1;
             }else {
                 return mid;
             }
         }
     	
     	return -1;
    }
	//Ceiling is implemented using binary Search
	public static int ceiling(int[] arr,int target) {
		
		int start = 0 ; 
		int end  = arr.length;
		
		
		while(start <= end) {
			
			int mid = start  + (end- start) / 2;
			if(arr[mid] == target) {
				return arr[mid];
			}
			else if(arr[mid] < target) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return arr[start];
	}
	
	//Floor is implemented using binary Search
	public static int floor(int[] arr, int target) {
		
		int start = 0 ; 
		int end = arr.length - 1;
		
		while(start <= end) {
			
			int mid = start + (end - start) / 2;
			
			if(arr[mid] == target) {
				return arr[mid];
			}else if(arr[mid] < target) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
			
		}
		
		return arr[end];
	}
	
	//Ceiling in character array
	public static char nextGreatestLetter(char[] letters, char target) {
        
        //non-decreasing meanascending order
        
        int start = 0;
        int end = letters.length - 1;
        

        while(start <= end) {
        	
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
 
	//Peak on mountain array
    public static int peakIndexInMountainArray(int[] arr) {
        
        // instead of target use mid + 1(next element)
        
        int start = 0;
        int end = arr.length - 1;
        
        while(start < end){
            
            int mid = start + (end - start) / 2;
            
            if(arr[mid] > arr[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
    
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		//int[] arr = {1,2,3,4,5,8,8,8,9,10};
		//System.out.println(Arrays.toString(firstAndLastOcc(arr,8)));
		
		//int[] arr1 = {10,9,8,7,6,5,4,3,2,1};
		//System.out.println(Search(arr1,7));

		/*
		int[] arr2 = {2,3,5,9,14,16,18};
		int target = in.nextInt();
		System.out.println("Ceiling of "+target+": "+ceiling(arr2,target));
		System.out.println("Floor of "+target+": "+floor(arr2,target));
		
		char[] letters = {'x','x','y','y'};
		System.out.println("Char:\n"+nextGreatestLetter(letters,'z'));
	*/
		
		int[] arr3 = {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target = 3;
		//System.out.println(infiniteArray(arr3,target));
        
        int[] arr4 = {4,5,6,7,0,1,2};
        int peek = peakIndexInMountainArray(arr4);
        System.out.println(infiniteSearch(arr4,0,peek,target));
        System.out.println(infiniteSearch(arr4,peek,arr4.length -1,target));
        
	}
	
}
