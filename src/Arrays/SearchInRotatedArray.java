package Arrays;
import java.util.*;

//Approach:
// 1.Initialize two pointers, low and high, representing the start and end of the array.
// 2.Repeat while low is less than or equal to high:

//    Calculate mid as the middle index between low and high.

//     If nums[mid] equals target, return mid as the answer.

//    Check if the left half (from low to mid) is sorted:
//         - If target lies between nums[low] and nums[mid - 1], move high to mid - 1.
//         - Otherwise, move low to mid + 1.

//     If left half is not sorted, right half must be sorted:
//         - If target lies between nums[mid + 1] and nums[high], move low to mid + 1.
//         - Otherwise, move high to mid - 1.

//  If the loop ends without finding the target, return -1.
//
// Time Complexity: O(log n)
// Space Complexity: O(1)
public class SearchInRotatedArray
{
    public static void main(String args[])
    {
        SearchInRotatedArray ob = new SearchInRotatedArray();
        Scanner in = new Scanner(System.in);
        int[] nums = {2, 5, 3, 1, 6, 8};
        int target = 3;
        System.out.println(ob.search(nums, target));  // Should print index of target or -1
    }

    public int search(int[] nums, int target)
    {
        int low=0;
        int high=nums.length - 1;

        // Apply modified binary search until low crosses high
        while (low<=high)
        {
            int mid=(low+high) / 2;

            if (nums[mid]==target)
            {
                return mid;//if target found immadiately return the index
            }

            if (nums[low] <= nums[mid])  // Left half is sorted
            {
                if (target >= nums[low] && target < nums[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else  // Right half is sorted
            {
                if (target>nums[mid] && target <= nums[high])
                {
                    low=mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }

        return -1;//target not found return -1
    }
}
