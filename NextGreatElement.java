
// Time Complexity : O(N) // 4N
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Arrays;
import java.util.Stack;

class NextGreatElement {
	public int[] nextGreaterElements(int[] nums) {
		Stack<Integer> stack = new Stack<>();

		int n = nums.length;
		int[] result = new int[n];
		Arrays.fill(result, -1);

		for (int i = 0; i < 2 * n; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
				int temp = stack.pop();
				result[temp] = nums[i % n];
			}
			if (i < n)
				stack.push(i);
		}
		return result;
	}
}