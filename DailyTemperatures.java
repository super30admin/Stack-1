// Time Complexity : O(2n) ~ O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int popped = st.pop();
                result[popped] = i-popped;
            }
            st.push(i);
        }
        return result;
    }
}