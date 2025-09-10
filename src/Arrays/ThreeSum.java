package Arrays;

import java.util.*;

// Approach explanation:
// 1. First, sort the array in increasing order to make the two-pointer method work properly.
// 2. Go through each element one by one, and treat it as the first number of the triplet.
// 3. Then, use two pointers: one starting just after the current element (left) and one at the end of the array (right).
// 4. Check the sum of the three numbers (current element + left + right).
// 5. If the sum is exactly zero, save the triplet into the result list.
// 6. After finding a valid triplet, skip any duplicate numbers by moving the pointers accordingly.
// 7. If the sum is less than zero, move the left pointer to the right to increase the sum.
// 8. If the sum is greater than zero, move the right pointer to the left to decrease the sum.
// 9. Continue this process until all triplets are found.
public class ThreeSum
{
    public static void main(String args[])
    {
       int arr[]={1,-1,0,2,1,-2,3,4,5};
       Arrays.sort(arr);
        ThreeSum ob = new ThreeSum();
        List<List<Integer>> result = ob.twopointer(arr);

        // Print the result
        for (List<Integer> triplet : result)
        {
            System.out.println(triplet);
        }
    }


        List<List<Integer>>twopointer(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum == 0)
                    {
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left ++;
                        right--;
                    }
                    else if (sum < 0)
                    {
                        left++;
                    } else
                    {
                        right--;
                    }
                }
            }
            return ans;
        }
}
