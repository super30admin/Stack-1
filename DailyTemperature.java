// Time Complexity : O(2n) where n is the number of temperatures in the array
// Space Complexity : O(n) where n is the number of temperatures in the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Push the temperatures. As soon as a temperature is greater than the peek implies, a warmer
temperature and it resolves the peek. Now check if it also resolves the rest of the temperatures in the stack, if yes, then keep popping till it resolves
those temperatures. Store the difference between the peek index and incoming temperature index in the result array as the number of days. Return the result.
*/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        if(T.length == 0 || T == null){return new int[0];}                                              // Edge case
        Stack<Integer> stk = new Stack<>();
        for(int i  =0; i < T.length; i++){
            while(!stk.isEmpty() && T[i] > T[stk.peek()]){                                              // Compare the stack peek with the incoming temperature
                int index = stk.pop();                                                                  // Index that is greater
                result[index] =  i - index;                                                             // Store the difference in the result array as number of days
            }
            stk.push(i);                                                                            // Push the temperatures in the stack
        }
        return result;
    }
}