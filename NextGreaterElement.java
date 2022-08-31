import java.util.Arrays;
import java.util.Stack;

//Time complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[] {};
        if (nums.length == 1) {
            return new int[] { -1 };
        }
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1); // if any element is not processed, -1 is used.

        for (int i = 0; i < 2 * n; i++) {
            while (!s.isEmpty() && nums[i % n] > nums[s.peek()]) {
                int idx = s.pop();
                result[idx] = nums[i % n];
            }
            if (i < n) {
                s.push(i); // pushing elements into the stack, only from 1st iteration.
            }
        }
        return result;

    }
}