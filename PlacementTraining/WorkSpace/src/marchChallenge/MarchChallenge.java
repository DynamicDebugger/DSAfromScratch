package marchChallenge;
import java.util.*;
public class MarchChallenge {

	
	
	//Day 17 => 57. Insert Interval
	//intervals = [[1,3],[6,9]], newInterval = [2,5]
	public static int[][] day16(int[][] intervals, int[] newInterval){
		
        //to return the newly formed interval we first create 2D array list later convert it into the 2D array
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        int n = intervals.length;
        int i = 0;
        
        // Add intervals that come before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            arr.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            i++;
        }
        
        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        // Add the merged interval
        arr.add(new ArrayList<>(List.of(newInterval[0], newInterval[1])));
        
        // Add remaining intervals
        while (i < n) {
            arr.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            i++;
        }
        
        // Convert ArrayList to 2D array
        int[][] result = new int[arr.size()][2];
        for (int j = 0; j < arr.size(); j++) {
            result[j][0] = arr.get(j).get(0);
            result[j][1] = arr.get(j).get(1);
        }
        
        return result;
	}

	//Day 18 => 452. Minimum Number of Arrows to Burst Balloons
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // Custom comparator for sorting
        Comparator<int[]> customComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                // Compare by first element
                int cmp = Integer.compare(arr1[0], arr2[0]);
                // If first elements are the same, compare by second element
                if (cmp == 0) {
                    return Integer.compare(arr1[1], arr2[1]);
                }
                return cmp;
            }
        };

        Arrays.sort(points, customComparator);

        int arrows = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
            System.out.println(i + " => " + Arrays.toString(points[i])+ " end => " + end );
        }

        return arrows;
    }

	

    // Sort the matrix using custom comparator
   

	//Day 19 => 621. Task Scheduler
//    public static int leastInterval(char[] tasks, int n) {
//        
//    }
//	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[][] intervals = {
//				{1, 3},
//				{6, 9}
//		};
//		
//		int[] newInterval = {2, 5};
//		
//		int[][] intervals1 = {
//				{1, 2},
//				{3, 5},
//				{6, 7},
//				{8, 10},
//				{12, 16}
//		};
//		int[] newInterval1 = {4, 8};
//		System.out.println(Arrays.deepToString(day16(intervals, newInterval)));
//		System.out.println(Arrays.deepToString(day16(intervals1, newInterval1)));

		int[][] points = {
				{10,16},
				{2,8},
				{1,6},
				{7,12}
		};
		
		System.out.println(findMinArrowShots(points));
	}

}
