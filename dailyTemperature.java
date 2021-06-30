// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        if(temperatures == null || temperatures.length == 0) return result;
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            int curr = temperatures[i];
            while(!st.isEmpty() && temperatures[st.peek()] < curr){
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);
        }
        return result;
    }
}
