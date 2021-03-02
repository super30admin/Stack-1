import java.util.Arrays;
import java.util.Stack;

/*
 * The Time complexity of the algorithm is O(2*n) where n is no of elements.
 * The Space complexity of the algorithm is O(n) where n is no of elements.
 */

public class NextGreaterElementII {

	public int[] nextGreaterElements(int[] nums) {

		int[] result = new int[nums.length];

		if (nums.length == 0 || nums == null)
			return result;

		Arrays.fill(result, -1);

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < 2 * nums.length; i++) {

			while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {

				int idx = stack.pop();

				result[idx] = nums[i % nums.length];
			}

			if (i < nums.length) {
				stack.push(i);
			}

		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
