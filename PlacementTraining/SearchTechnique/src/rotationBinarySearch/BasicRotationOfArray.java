package rotationBinarySearch;

import java.util.Arrays;

public class BasicRotationOfArray {
    
	static void leftRotate(int[] arr, int n, int d) {
        // code here
        d = d % n;
        
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);        
        reverse(arr,0,n-1);
        
    }
    
    static void reverse(int[] arr,int i, int j){
        
 
        while(i <= j){
            
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            i++;
            j--;
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,2,3,4,5,6};
		
		leftRotate(arr, arr.length, 15);
		
		System.out.println(Arrays.toString(arr));
	}

}
