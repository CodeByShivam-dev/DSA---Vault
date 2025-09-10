package Arrays;
import java.util.*;

public class TwoSum
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int[] arr={7,2,11,15};
        int tar=9;
        int c;
        System.out.println("select 1 for two pinter appraoch");
        System.out.println("select 2 for Hashmap appraoch");
        c=in.nextInt();
        TwoSum ob=new TwoSum();

        if(c==1)
        {
            int[] result = ob.twopointer(arr,tar);//storing values of function

            System.out.println("Pair of indices: " + Arrays.toString(result));
            System.out.println("Pair of values: " + arr[result[0]] + ", " + arr[result[1]]);
        }
        else if(c==2)
        {
            int[] resul = ob.Hashmap(arr,tar);//storing values of function

            System.out.println("Pair of indices: " + Arrays.toString(resul));
            System.out.println("Pair of values: " + arr[resul[0]] + ", " + arr[resul[1]]);

        }
        else
        {
            System.out.println("enter proper choice");
            
        }


        int[] result = ob.twopointer(arr,tar);//storing values of function

        System.out.println("Pair of indices: " + Arrays.toString(result));
        System.out.println("Pair of values: " + arr[result[0]] + ", " + arr[result[1]]);
    }


/*  TWO PONINTER METHOD

   It is efficient when array is sorted

   1.first sort the array
   2.take first elemnt in left pinter and last elemnt in right pointer

   Check sum:
   1.If equal → return indices
   2.If smaller → move left forward
   3.If larger → move right backward

Return [-1, -1] if no pair found

 */
    int[] twopointer(int[] nums,int target)
    {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;

        while(left<right)
        {
            int sum=nums[left]+nums[right];
            if(sum==target)
            {
                return new int[]{left,right};
            }
            else if(sum>target)
            {
                right--;
            }
            else
            {
                left++;
            }
        }
        return new int[]{-1,-1};
    }

    /* HASHMAP APPROACH
1. Go through the array element by element
2.Find what number is needed to reach target
 3.Check if required  is already in the map
4⃣ If yes → return both indices
5Else → store current number and its index
6If no pair matches → return [-1, -1]

     */
    public int[] Hashmap(int[] nums, int target)
    {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int needednumber=target-nums[i];
            if(map.containsKey(needednumber))
            {
                return new int[]{map.get(needednumber),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

}
