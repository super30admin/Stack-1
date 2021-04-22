// Time Complexity : O(2n) n - length of T array
// Space Complexity : O(t) t- maximum interval of next higher temperature day
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer>  st = new Stack<>();
        int[] res = new int[T.length];
        int i=0;
        st.push(i++);
        while(i<T.length){
            while(!st.isEmpty() && T[st.peek()] < T[i]){
                res[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i++);
        }
        return res;
    }
}
