// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //null
        if(temperatures == null || temperatures.length == 0) return new int[0];
        int [] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < temperatures.length; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);
        }
        return result;
    }
}