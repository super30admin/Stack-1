// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(Integer.MAX_VALUE);
        int[] res = new int[temperatures.length];
        int topIdx = -1;
        int top = -1;

        for (int i = 0; i < temperatures.length; i++) {
            top = st.peek() == Integer.MAX_VALUE ? st.peek() : temperatures[st.peek()];

            while (temperatures[i] > top) {
                topIdx = st.pop();
                res[topIdx] = i - topIdx;
                top = st.peek() == Integer.MAX_VALUE ? st.peek() : temperatures[st.peek()];
            }
            st.push(i);
        }
        return res;
    }
}