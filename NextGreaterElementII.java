// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int popped = st.pop();
                result[popped] = nums[i % n];
            }
            if (i < n)
                st.push(i);
        }

        return result;
    }
}