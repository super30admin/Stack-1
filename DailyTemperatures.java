// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
	/* Here, the temperatures are retrieved from the array and checked where it is greater than the temperature at the top of the stack.
	 * If true, then the index stored in the stack will be popped and difference between the index from the stack and the index of the 
	 * compared temperature is assigned in the result index array.
	 */

import java.util.Stack;

public class DailyTemperatures {
	public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st = new Stack<>();
        int [] result = new int [T.length];
        if(T == null || T.length == 0) return result;
    
        for(int i = 0; i< T.length; i++){
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int index = st.pop();
                result[index] = i - index;
            }
            st.push(i);
        }
        return result;
    }
}
