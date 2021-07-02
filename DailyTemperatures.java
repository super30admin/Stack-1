// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through the entire array only once
//Space Complexity: O(1) since we are not taking any extra space

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return temperatures;
        int[] res = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1; i < temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int idx = st.pop();
                res[idx] = i - idx;
            }
            st.push(i);
        }
        return res;
    }
}