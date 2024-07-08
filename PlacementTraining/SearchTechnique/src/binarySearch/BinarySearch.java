package binarySearch;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
    
    //Same as ceiling algorithm
    public static int searchInsert(int[] nums, int target) {
        
        int s = 0;
        int e = nums.length - 1;
        
        while(s <= e){
            
            int mid = s + (e - s)/2;
            
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        
        return s;
    }
    
    //LeetCode 350
    public static int[] intersect(int[] nums1, int[] nums2) {
        
        
        //Create two HashMap for two arrays
        
        //HashMap 1
        Map<Integer,Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        
        //HashMap 2
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        
        
        //Now compare both HashMap keys
        //If yes,then append the min value of both map to an array
        Set<Integer> keysSet = (map1.size() < map2.size()) ? map1.keySet() : map2.keySet();
        
        int i = 0;
        int[] arr = new int[(nums1.length < nums2.length)?nums1.length:nums2.length];
        
        for(int key: keysSet){
            
            if(map1.containsKey(key) && map2.containsKey(key)){
            	
            	int minSize = (map1.get(key) < map2.get(key)) ? map1.get(key) : map2.get(key);
            	
            	for(int j = 0 ; j < minSize ; j++) {
            		System.out.println(key);
            		arr[i++] = key;
            	}
            }
            
        }
        return Arrays.copyOfRange(arr, 0, i);
    }
    
    public static void printMap(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
    
    
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		 int[] arr = {1, 3, 20, 4, 1, 0};
        int peak = peakIndexInMountainArray(arr);
        if (peak != -1) {
            System.out.println("Peak element found: " + peak);
        } else {
            System.out.println("No peak element found.");
        }
        

		//int[] arr = {1,2,3,4,5,8,8,8,9,10};
		//System.out.println(Arrays.toString(firstAndLastOcc(arr,8)));
		
		//int[] arr1 = {-1,0,3,5,9,12};
		//System.out.println(Search(arr1,2));

		/*
		int[] arr2 = {1, 6};
		int[] arr1 = {3, 9};
		int[] newInterval = {4, 8};
		int[][] intervals = {
				{1, 2},
				{3, 5},
				{6, 7},
				{8, 10},
				{12, 16}
		};
		*/
//		int target = in.nextInt();
//		System.out.println("Ceiling of "+target+": "+ceiling(arr2,target));

//		for(int i = 0 ; i < intervals.length ; i++) {
//			
//			int start = intervals[i][0];
//			int end = intervals[i][0];
//			
//			
//		}
		/*
		int s = newInterval[0];int e = newInterval[1];
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		for(int i = 0 ; i < intervals.length ;i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}
		System.out.println(Arrays.deepToString(intervals));
		System.out.println("start => "+Arrays.toString(start));
		System.out.println("end => "+Arrays.toString(end));
		System.out.println("Floor of "+s+": "+floor(start, s));
		System.out.println("Floor of "+ e +": "+floor(end, e));
		int indexStart = Math.min(floor(start, s), s);
		int indexEnd = Math.max(e, floor(end, e));
		System.out.println(indexStart);
		System.out.println(indexEnd);
		*/
//		for(int i = index ; i < intervals.length ;i++) {
//			
////			if(start[index] <= start[i])
//		}
		
		
//		char[] letters = {'x','x','y','y'};
//		System.out.println("Char:\n"+nextGreatestLetter(letters,'z'));
	
		/*
		int[] arr3 = {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target = 3;
		//System.out.println(infiniteArray(arr3,target));
        */
        //int[] arr4 = {1,2,1,3,5,6,4};
        //System.out.println(peakIndexInMountainArray(arr4));
        /*
        System.out.println(infiniteSearch(arr4,0,peek,target));
        System.out.println(infiniteSearch(arr4,peek,arr4.length -1,target));
        */
		
		//int[] arr4 = {1,3,5,6};
		//System.out.println(searchInsert(arr4,7));
		
//		int[] nums1 = {1,2,2,1,2,3,1};
//		int[][] nums2 = {
//				{1,2},
//				{3,3},
//				{4,2}
//		};
//		
////		System.out.println(Arrays.toString(intersect(nums1,nums2)));
//		System.out.println(Arrays.toString(unmarkedSumArray(nums1,nums2)));
	}
	
    public static long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long[] sums = new long[queries.length];
        int j = 0;
        
        for (int[] query : queries) {
            int index = query[0];
            int k = query[1];

            int[] copyOfNums = Arrays.copyOf(nums, nums.length);
            Arrays.sort(copyOfNums);

            int target = nums[index];
            int count = 0;
            long sum = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    count++;
                    nums[i] = 0;
                    if (count == k)
                        break;
                }
            }
    		System.out.println(k+ " => "+Arrays.toString(copyOfNums));

            for (int num : nums) {
                sum += num;
            }

            sums[j++] = sum;
        }
        return sums;
    }
}
