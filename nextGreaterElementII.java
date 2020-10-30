// TC: O(N) traversing the length of array
// SC: O(N) for the stack

// Iterating over the array circularly such that when the number at current index is greater than next index, we need to pop the index from the stack
// since we might find the numbers greater than current in further indices. calculate the result if the stack is not empty with the
// values from the top index in nums array and add the index onto stack, we add i%n since we are checking circularly until we reach the start of the array

import java.util.*;
public class nextGreaterElementII {

	public int[] nextGreater(int[] nums) {
		
		int n = nums.length;
		int[] res = new int[nums.length];
		Stack<Integer> st = new Stack<>();
		
		for(int i=2*n-1;i >= 0;i--) {
			
			while(!st.isEmpty() && nums[st.peek()] <= nums[i%n]) {
				st.pop();
			}
			res[i] = st.isEmpty() ? -1 : nums[st.peek()];
			st.push(i%n);
		}
		return res;
	}
}
