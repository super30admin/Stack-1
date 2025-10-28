// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We use stack to add the cooler temperatures and when we encounter warmer temperature we pop the element from the top of the stack and get the difference between its indices
//We keep doing this until we handle all temperatures one by one.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int poppedIdx = st.pop();
                result[poppedIdx] = i - poppedIdx;
            }
            st.push(i);

        }
        return result;

    }
}
