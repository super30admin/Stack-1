// Time Complexity : O(n), where n is the size of the array (exactly O(2n), as we can touch an element maz 2 times)
// Space Complexity : O(n), where n is the size of the array (space for stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain English
//1. Create a stack (to hold the indices for which you have to find the next warmer day), and initailly push 0th index in the stack
        //as a starting index (for ehich you will try to find the next warmer day)
//2. Iterate over the T array starting for index 1 (as this pointer denotes the next possible warmer day for the day at stack top)
//3. "WHILE" it is the next warmer day AND stack is not yet empty (basically, the day at ith index can be the next warmer day for 
        //multiple days in th stack), pop the stack and calcuate the number of days (i-stack.pop()) and update the result arrary 
        //at the poped index.
        //Now push the ith index in the stack(we want to find the next warmer day for this now), and keep doing the above steps

// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] T) {
        //result array
        int[] result = new int[T.length];
        //edge case
        if(T == null || T.length == 0) return result;
        
        //create a stack to check the warmer days
        Stack<Integer> st = new Stack<>();
        //add the first index to the stack (basically we will try to find a warmer day starting here)
        st.push(0);
        
        //iterate over the temperatures
        for(int i=1; i<T.length; i++){
            //check if this temperature is the next warmer day for the day at stack top
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int idx = st.pop();
                result[idx] = i-idx;
            }
            st.push(i);//push the current index in the stack (as we have to find a warmer day for this too)
        }
        return result;
    }
}