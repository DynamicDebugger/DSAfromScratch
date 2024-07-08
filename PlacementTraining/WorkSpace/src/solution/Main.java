package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int maxSubArrayProduct(int[] nums) {
		
		int n = nums.length - 1 , prefix = 1, sufix = 1;
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i <= n ; i++) {
			
			//prefix updation
			if(nums[i] == 0) {
				prefix = 1;
                max = Math.max(max, 0);
			}else {
				prefix *= nums[i];
                max = Math.max(max, prefix);
			}
			
			
			//sufix updation
            
			if(nums[n - i] == 0) {
				sufix = 1;
                max = Math.max(max, 0);
			}else {
				sufix *= nums[n - i];
                max = Math.max(max, sufix);
			}
			
			
		}
		return max;
	}
    public static int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;

        int prev = 1, next = 1;

        for(int i = 1 ; i < n ; i++){
            next *= nums[i];
        }

        //update of first result in the array
        int temp  = nums[0];
        nums[0] = next;
        
        //now repeat the same process for all elements
        for(int i = 1 ; i < n ; i++){
//            System.out.println(i + " next =  "+next + " prev =  " +prev);
            if(nums[i] == 0){
                int j = i + 1;
                next = 1;
                while(j < n){
//                	System.out.println("j = "+ j + " next = " + next + " nums[j] = " + nums[j] + " next => "+ next * nums[j]);
                    next *= nums[j];
                    j++;
                }
//                System.out.println("if "+nums[i] + " next =  "+next + " prev =  " +prev);

            }            
            else{
                next /= nums[i];
                
            }
//            System.out.println(i + " next= "+next );
//            System.out.println(i +
////            		" prev = "+prev +
//            		" temp " + temp  + " prev => " + prev * temp );
            prev *= temp;
            temp = nums[i];
            nums[i] = next * prev;
            System.out.println(i+" nums:  "+ nums[i]+" next = " + next + " prev =  " +prev);
        }

        return nums;
    }
    
    public static int numSubarraysWithSum(int[] nums) {
        

        int n = nums.length;
        
        int i = 2,possible = 0;
        
        while(i <= n) {
        	
        	possible = Math.max(possible, slidingWindow(nums,i,i,n));
//        	System.out.println(possible+" "+slidingWindow(nums,i,i,n));
        	i++;
        }

        return possible;
    }
    
    public static int slidingWindow(int[] arr, int d, int m, int n) {
    	// TODO Auto-generated method stub
		
    	int sum = 0;
    			//count = 0;
    	
    	//m is the window size 
    	for(int i = 0 ; i < m ; i++) {
    		sum += arr[i];
    	}
    	System.out.println(sum);
    	if(sum == d) {
    		//sum++;
    		return sum;
    	}
    	//move the window
    	for(int i = m ; i < n ; i++ ) {
    		sum += arr[i];
    		sum -= arr[i - m];
    		if(sum == d)
    			return sum;
    	}
    	return sum;
	}

    //**************** Main method is here ****************
	public static void main(String[] args) {
    	
    	int arr[] = {2, 3, -2, 4};
    	System.out.println(maxSubArrayProduct(arr));
    	
    	Scanner in = new Scanner(System.in);
    	
    	
    	
    	
//    	int i =1;
//    	while(i != 0) {
//    		i++;
//    	System.out.println(findMaxLength());
//    	}
//    	System.out.println(Arrays.toString(productExceptSelf(arr)));
//    	String s = "aabcaba";
//    	System.out.println(isSubstringPresent(s));
    }

//    public static boolean isSubstringPresent(String s) {
//        
//    	StringBuffer r =new StringBuffer (s);
//    	r. reverse();
//    	int n = s.length();
//    	
//    	for(int i = 0 ; i < n ; i++) {
//    		
//    		if(arr[i - 1] == arr[i])
//    	}
//    }
//    
//    public static int minimumDeletions(String word, int k) {
//        
//    }
    public static long countSubstrings(String s, char c) {
        
//    	long count  = 0 ;
//    	
//    	int n  = s.length();
//    	ArrayList<Integer> ar = new ArrayList<>();
//    	
//    	for(int i = 0 ; i < n ; i++) {
//    		
//    		if(s.charAt(i) == c) {
//    			ar.add(i);
//    		}
//    	}
////    	n--;
//    	count = ar.size();
//    	System.out.println(ar.toString());
////    	for(int index:ar) {
////    		
////    		System.out.println(index + " => " + " count = " + count + " after "+ (count + ( n - index )) );
////    		count += (n - index);
////    	}
//    	
//    	for(int i = 0 ; i  < ar.size() ; i++) {
//    		
//    		for(int j = i+1 ; j < ar.size() ;j++) {
//    			count++;
//    		}
//    	}
//    	
//		return count;
    	
        int n = s.length();
        long count = 0;
        int cCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                cCount++;
            }
        }
        
        // Calculate the total count of substrings
        count = (long) cCount * (cCount + 1) / 2;
        
        return count;
    }
    public static int findMaxLength(int[] nums) {
        

        int n = nums.length;
          
        
        int[] arr = new int[n];
		int sum = 0;
        for(int i = 0 ; i < n ; i++) {
        	
    		if(nums[i] == 1)
        		sum += 1;
    		else
    			sum -= 1;
    		arr[i] = sum;
        }
        System.out.println(Arrays.toString(arr));
        int max = 0;
        for(int i = 0 ; i < n ; i++) {
        	
        	int f = arr[i];
        	for(int j = i+1 ; j < n ; j++) {
        		
        		if(f == arr[j] && j - i > max) {
        			max = j - i;
        		}
        	}
        	if(arr[i] == 0  && i+1 > max)
        		max = i + 1;
        }
        return max;
    }

	public static boolean slideWindow(int[] arr, int m, int n) {
		// TODO Auto-generated method stub
		
		int sum = 0;
    	for(int i = 0 ; i < m ; i++) {
    		
    		if(arr[i] == 1)
        		sum += 1;
    		else
    			sum -= 1;
    		
    	}
    	if(sum == 0) {
    		return true;
    	}
    	
    	for(int i = m ; i < n ; i++) {
    		
    		if(arr[i] == 1)
        		sum += 1;
    		else
    			sum -= 1;
    		
    		sum -= arr[i - m];
    
    		if(sum == 0)
    			return true;
    	}
		
		return false;
	}
}
