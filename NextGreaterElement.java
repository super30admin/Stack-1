
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No





import java.util.*;

public class NextGreaterElement {

	public int[] nextGreaterElements(int[] nums) {

		Stack<Integer> stack = new Stack<>();
		int[] res = new int[nums.length];
		Arrays.fill(res,-1);
		int n = nums.length;
		int i = 0;
		for (i = 0; i < 2 * n; i++) {

			while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
				int priorIndex = stack.pop();
				res[priorIndex] = nums[i % n];
			}
			if (i < n) {
				stack.push(i%n);
			}
		}

	

		return res;

	}

	public static void main(String[] args) {

		NextGreaterElement n = new NextGreaterElement();

		int[] res = n.nextGreaterElements(new int[] { 2, 3, 5, 6, 7, 9, 3, 5, 6, 8 });

		for (int i : res) {
			System.out.println(i);
		}
	}

}
