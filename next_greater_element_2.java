// Time Complexity : O(n) because each index is pushed and popped at most once
// Space Complexity : O(n) for the stack and result array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use a Monotonic Decreasing Stack to find the next greater element for each index.
// Since the array is circular, we simulate two passes using modulo to wrap around.
// The second pass only helps resolve pending elements; we push indices only during the first pass.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < 2 * n; i++) {
            int idx = i % n;

            // resolve smaller elements
            while(!st.isEmpty() && nums[idx] > nums[st.peek()]) {
                int popped = st.pop();
                result[popped] = nums[idx];
            }

            // push only in first pass
            if(i < n) {
                st.push(i);
            }
        }

        return result;
    }
}