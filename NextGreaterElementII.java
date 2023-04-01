import java.util.Arrays;
import java.util.Stack;
//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Iterate twice the size of the array to satisfy circular array condition. At
 * each iteration, do i%n so that i remains in length of n. If the peek <
 * current element, update peek index in answer array with the current element
 * and then push the current index % n. Return answer array.
 *
 */
class Solution {
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		Arrays.fill(ans, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 2 * n; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
				ans[stack.pop()] = nums[i % n];
			}
			stack.push(i % n);
		}
		return ans;
	}
}
