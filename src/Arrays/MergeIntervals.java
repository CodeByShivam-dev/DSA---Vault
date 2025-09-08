package Arrays;

import java.util.*;

//firstly sort the intervals
//Create a result list.
//Iterate through intervals ek hi pass me:

//Case 1: Result list empty hai → add interval.

//Case 2: Last added interval does not overlap with current → add interval.

//Case 3: Last added interval overlaps with current → merge them
        //(update last interval’s end to max(lastEnd, currentEnd)).

public class MergeIntervals
{
    static class Solution
    {
        public int[][] merge(int[][] intervals)
        {
            // Step 1: Sort intervals based on start time
            Arrays.sort(intervals,(a, b) -> a[0] - b[0]);

            // Step 2: Create list to store merged intervals
            List<int[]>result=new ArrayList<>();

            // Step 3: Use normal for loop
            for (int i = 0; i < intervals.length; i++)
            {
                // If result is empty OR no overlap
                if (result.isEmpty() || result.get(result.size()-1)[1] < intervals[i][0]) {
                    result.add(intervals[i]);
                }
                else
                {
                    // Overlap → merge by updating end time
                    result.get(result.size() - 1)[1] =
                            Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
                }
            }

            // Step 4: Convert List<int[]> to int[][]
            return result.toArray(new int[result.size()][]);
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        // test case
        int[][] intervals = { {1,3}, {2,6}, {8,10}, {15,18} };

        int[][] merged = sol.merge(intervals);

        // Print merged intervals
        System.out.println("Merged Intervals:");
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
