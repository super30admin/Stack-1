// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Monotonoic decrease stack: Put the index of the higest value to the stack, and remove it if you find more higer value from it. set the difference of there index to the result array at that index.
// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        // null
        if( temp == null || temp.length == 0 ) return new int[0];
        int [] result = new int[temp.length];
        Stack<Integer> st = new Stack<>();
        // loop
        // st.push(0);
        for(int i = 0; i < temp.length; i++){
            while( !st.isEmpty() && temp[st.peek()] < temp[i]){
                int top = st.pop();
                result[top] = i-top;
            }
            st.push(i);
        }
        return result;
    }
}