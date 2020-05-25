// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Figuring out way of doing it by stack was difficult. I had to refre leetcode solution for this.


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] out = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for(int i = T.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && T[i]>=T[st.peek()]) st.pop();
            out[i] = st.isEmpty()?0:st.peek()-i;
            st.push(i);
        }
        return out;
    }
}public class temp {
    
}