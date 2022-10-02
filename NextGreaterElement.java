import java.util.Arrays;
import java.util.Stack;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        /*Monotonically decreasing Stack:
        [1,0,5,6,4,3,10,9,2,7]
        By default resultant array has -1 filled for each index, i.e no next greater element
        we start with 1, put that in the stack,
        we check 0 it's not greater than 1, we push 0 in the stack
        we go to 5, 5 is greater tha 0, we resolve 0, so popped index(1) = 5
        top of the element is now 1, 5 resolves 1 as well,
        we push 5 in the stack and move on
         3 is smaller than 4
         we don't have to compare 3 with 6 as it is already a monotnically decreasing stack

         with elements not resolved we go through the array again and resolve them
        */
        int n= nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        if(nums == null || nums.length ==0) return result;
        Arrays.fill(result,-1);
        for(int i=0;i<2*n;i++)
        {
            //0,1,2
            //3 is the 0th index so i%n = 0
            //4=1
            //5=2
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n])
            {
                int popped = st.pop();
                result[popped] = nums[i%n];

            } 
            if(i<n)
            st.push(i);

        }

        return result;
    }
    
}
