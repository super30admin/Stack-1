import java.util.Stack;

/**************************Brute Force******************************/
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Daily_Temperatures_BruteForce {
	public int[] dailyTemperatures(int[] T) {
		if(T == null || T.length == 0)
			return T;
		int[] result = new int[T.length];
		for(int i = 0; i<T.length; i++){
			result[i] = 0;
			for(int j=i; j<T.length; j++){
				if(T[j] > T[i]){
					result[i] = j - i;
					break;
				}
			}
		}
		return result;
	}
}

/**************************Using Stack******************************/
//Time Complexity : O(2n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**Push the index on to stack
 * If current ele is greater than peek element, we update result, and pop from the stack since the element would be resolved
 * If current ele is not greater than peek ele, then we move forward as we cannot resolve any elements 
 * **/
class Daily_Temperature_Stack {
	public int[] dailyTemperatures(int[] T) {
		if(T == null || T.length == 0)
			return T;
		int[] result = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<T.length; i++){
			while(!stack.isEmpty() && T[i] > T[stack.peek()]){  // till the stack is not empty and we can resolve the index to get a warmer day
				int index = stack.pop();    //resolved index;
				result[index] = i - index;
			}
			stack.push(i);
		}
		return result;
	}
}