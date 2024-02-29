import java.util.Stack;
import java.util.Arrays;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Used concept of monotonic descreasing stack

public class nextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        stk.push(0);
        for (int i = 1; i < 2 * n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i % n]) {
                result[stk.peek()] = nums[i % n];
                stk.pop();
            }
            if (i < n)
                stk.push(i);
        }

        return result;

    }
}
