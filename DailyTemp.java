package stack;

import java.util.Stack;

public class DailyTemp {

	/*
	 * // Approach: brute Force 
	 * 
	 * public int[] dailyTemperatures(int[] T) { 
	 * int[] result = new int[T.length];
	 * 
	 * for(int i=0;i<T.length;i++)
	 * { 
	 * 		int j=i+1; 
	 * 		while(j<T.length && T[i] >= T[j])
	 * 			j++;
	 * 
	 * 		result[i] = (j == T.length? 0 : j-i); 
	 * }
	 * 
	 * return result;
	 * }
	 * 
	 */
	// Approach : monotonic stack - Monotonically decreasing
	// We will maintain a stack, we keep pushing the elements which are lower than
	// the current stack top
	// At any point before pushing on the stack, we will check if the element if the
	// element is greater than stack top, if yees, then we found our next warmer
	// temprature, for all the elements in the stack which are warmer, keep poping.
	// Lastly push the element on stack
	// After iteration, if stack is not empty then we will not find any warmer
	// temprature later on, so we fill the temp with 0 values.

	public int[] dailyTemperatures(int[] T) {
		int[] result = new int[T.length];

		// push indexes onto stack rather than temp
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < T.length; i++) {
			int nextElement = T[i];
			while (!stack.isEmpty() && (nextElement > T[stack.peek()])) {

				result[stack.peek()] = i - stack.peek();
				stack.pop();
			}

			stack.push(i);
		}
		return result;
	}
}