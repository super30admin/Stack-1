// Time Complexity : O(n)  worst case O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class DailyTemperatures {                // decreasing stack
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<temperatures.length; i++){
            int currTemp = temperatures[i];
            while(!st.isEmpty() && currTemp >temperatures[st.peek()]){
                int popped = st.pop();
                result[popped] = i-popped;
            }
            st.push(i);
        }
        return result;
    }
}