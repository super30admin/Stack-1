//Time complexity is O(N)
//Space complexity is O(N)
//This solution is submitted on leetcode

import java.util.Arrays;
import java.util.Stack;

public class BigN130NextGreaterElementInCircularArray {
	class Solution {
		public int[] nextGreaterElements(int[] nums) {
			// edge case
			int[] result = new int[nums.length];
			if (nums == null || nums.length == 0)
				return result;
			Arrays.fill(result, -1);
			int n = nums.length;
			Stack<Integer> st = new Stack<>();
			for (int i = 0; i < 2 * n; i++) {
				while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
					int index = st.pop();
					result[index] = nums[i % n];
				}
				if (i < n)
					st.push(i);
			}
			return result;
		}
	}
}