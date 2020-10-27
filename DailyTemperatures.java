// Time Complexity : O(n) n for the input elements and n iterations for finding the next warmer temperature from the stack
// Space Complexity : O(n) n size for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Storing the indexes of each element in a stack helps us compare the each element.
// if my current index - element is greater than the stack's top element, iterate throught the stack till you get the greater amount or empty the stack.
// while iterating, store the differences in the output array.

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st = new Stack<>();
        int[] output = new int[T.length];

        for(int i = 0; i < T.length; i++) {
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int pop = st.pop();
                output[pop] = i - pop;
            }
            st.push(i);
        }

        return output;
    }
}