import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Tc: O(n) Sc: O(n)
        int n = nums.length;
        int res[] = new int[n];
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int j = 0; j < n; j++)
            res[j] = -1;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int id = st.pop();
                res[id] = nums[i % n];
            }
            if (i < n)
                st.push(i);

        }

        return res;
    }
}