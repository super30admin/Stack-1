//  Time Complexity: O(n)
//  Space Complexity: O(n)

import java.util.*;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(result, -1);

        for (int i = 0; i < 2*nums.length; ++i) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i % nums.length];
            }

            if (i < nums.length) {
                stack.push(i);
            }
        }

        return result;
    }
}
