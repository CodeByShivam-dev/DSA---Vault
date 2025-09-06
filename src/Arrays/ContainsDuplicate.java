package Arrays;
import java.util.*;

// Program to check if an array contains duplicate elements
// User can choose between two approaches:
// 1. Two Pointer Approach
// 2. HashSet Approach

public class ContainsDuplicate
{
    public static void main(String args[])
    {
        //Taking input from user so Scanner class used
        Scanner in = new Scanner(System.in);
        int arrs[] = {2, 5, 6, 3, 4, 3};

        //creating object of class
        ContainsDuplicate ob = new ContainsDuplicate();


        System.out.println("Choose 1 for Two Pointer Approach");
        System.out.println("Choose 2 for HashSet Approach");
        System.out.print("Enter your choice: ");
        int a = in.nextInt();

        boolean result = false;

        //based on user choice which appraoch he/she wants to run

        if (a == 1)
        {
            result = ob.twoPointerApproach(arrs);
        }
        else if (a == 2)
        {
            result = ob.hashSetApproach(arrs);
        }
        else
        {
            System.out.println("Invalid choice!");
            System.exit(0);
        }

        System.out.println("Contains Duplicate? " + result);
        in.close();
    }

    // Two Pointer Approach
    // ✅ Two Pointer Approach Explanation
    // First, sort the array so that any duplicates come next to each other.
    // Then  simply check adjacent elements one by one.
    // If  find any two elements equal,  immediately return true.
    // Otherwise, after full traversal, return false.
    // This approach is good if we  want to save space (no extra memory).
    // Time Complexity: O(n log n) because of sorting
    // Space Complexity: O(1)
    public boolean twoPointerApproach(int[] arrs)
    {
        Arrays.sort(arrs);  // Sorting the array
        int i = 0, j = 1;
        while (j < arrs.length)
        {
            if (arrs[i] == arrs[j])
            {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }

    // HashSet Approach
    // ✅ HashSet Approach Explanation
    // I loop through each number in the array.
    // For each number, I check if it’s already in my HashSet.
    // If yes → that means this number appeared before → Duplicate found → return true.
    // Otherwise, I add the number to the set and keep going.
    // This is the fastest way in terms of time, but it uses extra memory to store the set.
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean hashSetApproach(int[] arrs)
    {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arrs)
        {
            if (set.contains(num))
            {
                return true;//duplicate found
            }
            set.add(num);//storing unique number
        }
        return false;//no duplicate all number are unique.
    }
}

