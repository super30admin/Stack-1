// Problem1 Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take a stack and array result fill array with 0. Iterate from 0 to end of temperatures and when stack is not empty and temperatures[i] > temperatures[st.peek()]
 * the pop the top element and add result[poppedIdx] = i-poppedIdx; After loop add i to the stack and finally return result
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int []result = new int[temperatures.length];
        Arrays.fill(result, 0);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i< temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int poppedIdx = st.pop();
                result[poppedIdx] = i-poppedIdx; 
            }
            st.push(i);
        }
        return result;
    }
}