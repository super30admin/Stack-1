// Time complexity is O(N)
// Space complexity is O(N)
// This solution is submitted on leetcode

import java.util.Stack;

public class BigN129DailyTemperatureSolution {
	class Solution {
		public int[] dailyTemperatures(int[] T) {
			int[] result = new int[T.length];
			// edge case
			if (T == null || T.length == 0)
				return result;
			Stack<Integer> st = new Stack<>();
			for (int i = 0; i < T.length; i++) {
				while (!st.isEmpty() && T[i] > T[st.peek()]) {
					int index = st.pop();
					result[index] = i - index;
				}
				st.push(i);
			}
			return result;
		}
	}
}