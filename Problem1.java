// Time Complexity : O(n)  - O(2n) precisely
// Space Complexity : O(n)
// This code worked successfully on LeetCode
// Since we have to result in number of positions/days after which a warmer day occurs we will push the positions on stack instead of the temperature.

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        // Edge Case
        if(T == null || T.length == 0)  return result; 
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0;i < T.length; i++){
            while(!st.isEmpty() && T[st.peek()] < T[i]){ // Is stack is empty and if warmer day is found for the top of the stack
                int idx = st.pop();
                result[idx] = i - idx; // add to the result the number of days after which the warmer day occured which is the difference in position
            }   
            st.push(i); 
        }
        return result;
    }
}
