import java.util.Stack;
//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Take a stack and push each index in to the stack. Before pushing check if the
 * current index is greater than stack's peek element. If so, get the difference
 * of the peek and current index and update in the peek element's index and pop
 * it. Finally return the answer.
 *
 */
class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int n = temperatures.length;
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
				ans[stack.peek()] = i - stack.peek();
				stack.pop();
			}
			stack.push(i);
		}

		return ans;
	}
}