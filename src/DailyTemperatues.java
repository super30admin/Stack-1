// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * https://leetcode.com/problems/daily-temperatures/
 * iterate through T array and push index of current day into stack,
 * pop all the index from stack whose temp is < current day temp and
 * fill out result array
 *
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return new int[0];
        
        Stack<Integer> st = new Stack<>();
        int [] res = new int[T.length];
        
        for(int i=0; i<T.length; i++) {
            int num = T[i];
            
            while(!st.isEmpty() && T[st.peek()] < num) {
                int idx = st.pop();
                res[idx] = i - idx;
            }
            
            st.push(i);
        }
        
        return res;
    }
}