import java.util.Stack;

/*
## Problem 1: Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)

Time Complexity :   O (n) 
Space Complexity :  O (n)
Did this code successfully run on Leetcode :    Yes (739. Daily Temperatures)
Any problem you faced while coding this :       No
 */
// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i< len; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int topIndex = st.pop();
                int diff = i - topIndex;
                result[topIndex] = diff;
            }
            st.push(i);
        }
        return result;
    }
}