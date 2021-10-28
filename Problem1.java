// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n= temperatures.length;
        int[] result = new int[n];
        st.push(0);
        for(int i=1;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int top = st.pop();
                result[top] = i-top;
            }
            st.push(i);
        }
        return result;
    }
}