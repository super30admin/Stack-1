 // TC: O(N) - N is length of the temperatures
// SC: O(N) for the stack

import java.util.*;
public class dailyTemperatures {

	public int[] DailyTemperatures(int[] T) {
		
		Stack<Integer> st = new Stack<>();
		int[] res = new int[T.length];
		
		for(int i=T.length-1; i>=0;i--) {
			// check if the stack is not empty and the previous value is less then current value, else pop the index stack, because 
			// may be when we pop, we might find a index where the values are greater than current value
			while(!st.isEmpty() && T[i]>=T[st.peek()])
				st.pop();
			// if the stack is empty, assign 0 because we know we have not found value greater then current value,
			// if not, we subtract the index stored in stack and actual index because we are finding values cnt from present temp to future greater temp
			res[i] = st.isEmpty() ? 0: st.peek()-i;
			// add the current index to stack so that it can be compared with next index for i.
			st.push(i);
		}
		//return result stores
		return res;
	}
}
