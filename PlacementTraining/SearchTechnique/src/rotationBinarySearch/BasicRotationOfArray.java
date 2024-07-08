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
    
	//To rotate array in right side direction i.e from last postition
	static void rightRotate(int[] arr, int n, int d) {
        // code here
        d = d % n;
        
        reverse(arr,0,n-1);
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);        

        
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

		int[] arr = {1,2,3,4,5,6,7};
		
		leftRotate(arr, arr.length, 3);
		
		System.out.println(Arrays.toString(arr));
		
		
		rightRotate(arr, arr.length, 3);

		
		System.out.println(Arrays.toString(arr));//when you do same no of left and right rotation simultaneously it will form cyclic and return original array
	}

}
