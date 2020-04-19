// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach: Used a monotonic stack to store values until found a temperature greater than the current one. Then subtracted the index from the current one and stored in result array

class Solution {
    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> st = new Stack<>();
        int[] result = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (!st.isEmpty() && T[i] > T[st.peek()]) {
                int index = st.pop();
                result[index] = i - index;
            }
            st.push(i);
        }

        return result;
    }
}