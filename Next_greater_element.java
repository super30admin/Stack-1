
//TC - O(N)
//SC - O(1)
import java.util.*;

class Solution1 {
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		Arrays.fill(result, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 2 * n; i++) {
			while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
				int index = stack.pop();
				result[index] = nums[i % n];
			}
			if (i < n) {
				stack.push(i);
			}
		}
		return result;
	}
}