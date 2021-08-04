// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if(temperatures == null || temperatures.length == 0) return result;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);
        }
        return result;
    }
}