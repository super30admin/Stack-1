// Time Complexity (TC): O(n), where n is the length of the temperatures array.
// Space Complexity (SC): O(n), where n is the length of the temperatures array.

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)
        {
            return new int[0];
        }
        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<temperatures.length; i++)
        {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i])
            {
                //resolve it
                int popped = st.pop();
                result[popped] = i- popped; 
            }
            st.push(i);
        }
        return result;
    }
}