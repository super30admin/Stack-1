// Time Complexity : o(length of Array)
// Space Complexity : O(length of Array)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len=T.length;
        int[] res= new int[len];
        Stack<Integer> st = new Stack<>();
        for(int i=len-1;i>=0;i--){
            while(!st.isEmpty() && T[st.peek()]<=T[i])
                st.pop();
            res[i]=st.isEmpty()?0:st.peek()-i;
            st.push(i);
        }
        
        return res;
    }
}
