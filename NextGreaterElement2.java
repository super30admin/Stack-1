
// Time complexity : O(n)
// Space complexity : O(n)
import java.util.*;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 3 };
        int[] result = nextGreaterElements(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                int popped = stack.pop();
                result[popped] = nums[i % n];
            }
            if (i < n)
                stack.add(i);
        }
        return result;
    }
}
