//TC = O(N)
//SC = O(N)

/*
 * We are using monotonic stack to solve this problem.
 */

import java.util.*;
public class NextGreaterElementII {

    public static int[] next(int[] nums)
    {
        if(nums == null || nums.length == 0) return new int[]{};

        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> s = new Stack<>();

        for(int i =0;i<nums.length*2;i++)
        {
            while(!s.isEmpty() && nums[i%nums.length]>nums[s.peek()])
            {
                int top = s.pop();
                result[top]=nums[i%nums.length];
            }

            if(i<nums.length)
            {
                s.push(i);
            }
        }

        return result;
    }

    public static void main(String args[])
    {
        int[] nums = {1,2,1};
        int[] ans = next(nums);
        for(int i:ans)
        {
            System.out.print(i+" ");
        }
    }
}
