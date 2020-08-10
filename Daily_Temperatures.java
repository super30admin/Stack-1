
//TC - O(3N)
//SC - O(1)
import java.util.*;

class Solution {
	public int[] dailyTemperatures(int[] T) {
		if (T == null || T.length == 0)
			return new int[0];
		Stack<Integer> stack = new Stack<>();
		int result[] = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				int index = stack.pop();
				result[index] = i - index;
			}
			stack.push(i);
		}
		return result;
	}
}