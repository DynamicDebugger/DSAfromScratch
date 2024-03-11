package insertionSort;

import java.util.Arrays;

public class InsertionSortAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,4,5};

		
		System.out.println(maximumHappinessSum(arr,1));
	}
	
    public static long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length - 1,i = 0;
        
        sort(happiness,n);
        int tot = 0;
        while(i < k && n >= 0){
            
            int last = (happiness[n] - i >= 0) ? happiness[n] - i  : 0;
            System.out.println("Tot: "+ (tot += last));
            System.out.println("K = "+ (i++));
            System.out.println("n = "+ (n--));
            //k++;
            //n--;
        }
        return tot;
    }
    
	static void sort(int[] arr, int n) {
		// TODO Auto-generated method stub
		//sort by parts
		
		for(int i = 0 ; i <= n - 2 ; i++) {
			
			for(int j = i + 1 ; j > 0 ; j--) {
				
				if(arr[j] < arr[j -1]) {
				int temp = arr[j - 1];
				arr[j - 1] = arr[j];
				arr[j] = temp;
				}else {
					break;
				}
				System.out.println("At j = "+ j +" : "+Arrays.toString(arr));
			}
			System.out.println(Arrays.toString(arr));

		}
	}

}
