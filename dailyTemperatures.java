// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if(temperatures.length==0){
            return result;
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int curr = st.pop();
                result[curr]=i-curr;
            }
            st.push(i);
        }
        return result;
    }
}