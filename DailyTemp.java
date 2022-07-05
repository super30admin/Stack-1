// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        // iterating over each index
        for (int i = 0; i < n; i++) {
            // while stack is not empty and current temperature is greater than peek of
            // stack,
            // write difference of indices in result
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                result[st.peek()] = i - st.pop();
            }
            st.push(i);
            result[i] = 0;
        }
        return result;
    }
}