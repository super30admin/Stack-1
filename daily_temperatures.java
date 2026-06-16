// Time Complexity : O(n) because each index is pushed and popped at most once
// Space Complexity : O(n) for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use a Monotonic Decreasing Stack to keep indices of temperatures that have not yet found a warmer day.
// When the current temperature is higher than the top of the stack, we resolve those previous colder days.
// The difference in indices gives the number of days to wait for a warmer temperature.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {

            // resolve colder days
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int popped = st.pop();
                result[popped] = i - popped;
            }

            st.push(i);
        }

        return result;
    }
}
