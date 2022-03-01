import java.util.Arrays;
import java.util.Stack;

// Time Complexity : Add : O(2N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        nextGreaterElements(nums);
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        if(nums == null || n == 0)
            return result;

        Stack<Integer> st = new Stack<>();  // S.C - O(n)

        for(int i=0; i< 2 * n; i++){  // T.C - O(2n)

            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                result[st.pop()] = nums[i%n];
            }

            if(i <= n-1){
                st.push(i);
            }
        }

        return result;

    }
}

