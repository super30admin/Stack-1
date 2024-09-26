// Time Complexity : O(n) where n is the length of array T
// Space Complexity : O(n) where n is the length of array T
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        if (T.length == 0) return ans;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < T.length; i++) {
            if (T[i] > T[st.peek()]) { // redundant condition to understand the code better
                while (!st.isEmpty() && T[i] > T[st.peek()]) {
                    ans[st.peek()] = i - st.pop();
                }       
            } 
            st.push(i);
        }
        return ans;
    }
}