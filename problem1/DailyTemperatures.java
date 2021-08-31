//Time Complexity : O(n), n -> Number of temperatures
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
package problem1;

import java.util.Stack;

public class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		if (temperatures == null || temperatures.length == 0) {
			return new int[0];
		}

		Stack<Integer> stack = new Stack<Integer>();
		int[] ans = new int[temperatures.length];

		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
				int idx = stack.pop();
				ans[idx] = i - idx;
			}
			stack.push(i);
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
		DailyTemperatures obj = new DailyTemperatures();
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] ans = obj.dailyTemperatures(temperatures);
		System.out.print("Temperatures: ");
		obj.print(temperatures);
		System.out.print("Answer: ");
		obj.print(ans);
	}

}
