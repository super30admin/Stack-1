// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // null
        if(temperatures == null || temperatures.length == 0) return new int[0];
        
        Stack<Integer> st = new Stack<>();
        int [] result = new int[temperatures.length];
        // st.push(0);
        
        for(int i=0; i<temperatures.length; i++){
            // if incoming temp is resolving top of st
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int top = st.pop();
                result[top] = i - top;
            }
            st.push(i);
        }
        return result;
    }
}