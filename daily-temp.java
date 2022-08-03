// Time Complexity : O(2N) = O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        // we will use stack - Monotonic stack of index Since we need the days based on index
        // when we want to compare values and order matters  - go for monotonic stack

        for (int i = 0; i < n; i++) {

            int temp = temperatures[i];

            // clean up -> try to create monotonic stack and record the ans
            while (!st.isEmpty() && temp > temperatures[st.peek()]) {
                // pop from the stack and record the answer
                int prev = st.pop();
                ans[prev] = i - prev;
            }

            st.push(i);
        }

        return ans;
    }
}