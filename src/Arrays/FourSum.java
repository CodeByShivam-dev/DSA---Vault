package Arrays;

import java.util.*;

//------FOUR SUM LEETCODE QUETSION------

//first sort the array for two pointer technique
//Use two nested loops to fix the first two numbers of the quadruplet.
//
//For the remaining two numbers, use two pointers (p and q) moving toward each other.
//
//Skip duplicate numbers to avoid repeating the same quadruplet in the result.
//
//Add quadruplets whose sum equals the target to the result list and return it.


//roughly understand
// [3,4,5,6,7,8,]
// 3 is taken as i
//4 is taken as j=i+1
//8 is taken as q=n-1
//5 is taken as p=j+1;
public class FourSum
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int arr[] ={-2, -1, -2, 0, 1, 2, 2, -1, 3};
        int target = 0;

        // calling two-pointer method and store the result
        List<List<Integer>> result = twopointer(arr, target);

        // Print the result
        for (List<Integer> quad : result) {
            System.out.println(quad);
        }
    }

    public static List<List<Integer>> twopointer(int[] nums, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])  // Skip duplicates for i
                continue;

            for (int j = i + 1; j < n - 2; j++)
            {
                if (j > i + 1 && nums[j] == nums[j - 1])  // Skip duplicates for j
                    continue;

                int p = j + 1;
                int q = n - 1;

                while (p < q)
                {
                    long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];

                    if (sum < target)
                        p++;
                    else if (sum > target)
                        q--;
                    else
                    {
                        result.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));

                        p++;
                        q--;

                        // Skip duplicates for p
                        while (p < q && nums[p] == nums[p - 1])
                            p++;

                        // Skip duplicates for q
                        while (p < q && nums[q] == nums[q + 1])
                            q--;
                    }
                }
            }
        }

        return result;
    }
}
