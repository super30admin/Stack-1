//Time Complexity : O(n), n -> Number of elements
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
package problem2;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
	public int[] nextGreaterElements(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}

		Stack<Integer> stack = new Stack<Integer>();
		int n = nums.length;
		int[] ans = new int[n];

		Arrays.fill(ans, -1);

		for (int i = 0; i < 2 * n; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
				int idx = stack.pop();
				ans[idx] = nums[i % n];
			}
			if (i < n) {
				stack.push(i);
			}
		}

		return ans;
	}

	private void print(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		NextGreaterElement2 obj = new NextGreaterElement2();
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] ans = obj.nextGreaterElements(temperatures);
		System.out.print("Input: ");
		obj.print(temperatures);
		System.out.print("Next Greater Elements: ");
		obj.print(ans);
	}

}
