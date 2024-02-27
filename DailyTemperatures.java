/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(2n)
    n - total items
* 
* Space Complexity: O(n)
* 
*/
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();

        int[] result = new int[temperatures.length];

        st.push(0);

        for(int index = 1; index < temperatures.length; index++){
            while(!st.isEmpty() && temperatures[index] > temperatures[st.peek()]){
                // resolve the lower temperatures
                result[st.peek()] = index - st.pop();
            }
            st.push(index);
        }

        return result;
    }
}