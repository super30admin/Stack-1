// Time Complexity : O(2N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using a decresing monotonic stack to check if the next element is greater
// resolve it and push it in.

// 739. Daily Temperatures

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return new int[0];
        int res [] = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int popped = st.pop();
                res[popped] = i - popped;
            }
            st.push(i);
        }
        return res; 
    }
}