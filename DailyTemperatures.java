// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // return empty array if input array is null or its length is 0
        if(temperatures == null || temperatures.length == 0) return new int[temperatures.length];
        int n = temperatures.length;
        // initailize result array and stack
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        // push the first index of input array in the stack
        st.push(0);
        // iterate through the input array
        for(int i = 1; i < n; i++){
            // if the teperature at i is greater than top-most element of stack,
            // then pop the element and store the difference of index in the result array
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int top = st.pop();
                result[top] = i - top;
            }
            // push index inside stack
            st.push(i);
        }
        // return the result array
        return result;
    }
}