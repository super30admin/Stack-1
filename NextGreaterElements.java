
import java.util.Arrays;
import java.util.Stack;

class Solution34 {
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		Arrays.fill(result, -1);

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n * 2; i++) {
			System.out.print(i);
			while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
				result[stack.pop()] = nums[i % n];
			}
			if (i > n && nums[i % n] == nums[stack.peek()])
				return result;
			stack.push(i % n);
		}
		return result;
	}
}

public class NextGreaterElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution34 s = new Solution34();
		int[] result = { 10, 3, 1, 17, 0, 18, 19, 13, 18 };
		s.nextGreaterElements(result);
	}

}
