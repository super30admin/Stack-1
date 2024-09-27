package stack;

import java.util.Arrays;
import java.util.Stack;

public class GreaterElementII {

	// Approach: Use monotonic stack
	// TC : O(n)
	// SC : O(n)
	public static int[] nextGreaterElements(int[] nums) {

		int[] result = new int[nums.length];
		Arrays.fill(result, -1);

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < 2 * nums.length; i++) {

			int loc = i % nums.length;

			while (!stack.isEmpty() && nums[loc] > nums[stack.peek()]) {
				int index = stack.pop();
				result[index] = nums[loc];
			}

			if (i < nums.length)
				stack.push(i);

		}

		return result;
	}

}
