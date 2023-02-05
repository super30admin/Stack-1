// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
 * maintain a stack to store the indexes of the temperatures one by one.
 * if we find a warmer temperature, find the idff between the next index and top index in stack
 * Else push the temperatures in the stack.
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0)
            return new int[0];
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int popIdx = st.pop();
                result[popIdx] = i - popIdx;
            }
            st.push(i);
        }
        return result;
    }
}