import java.util.Arrays;
import java.util.Stack;

public class GreaterNumber {
    // TC O(3N)
    // SC O(N)
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stk = new Stack<Integer>();
        int n = nums.length;
        for (int i = 0; i < 2 * n; i++) {
            while (!stk.isEmpty() && nums[i % n] > nums[stk.peek()]) {
                int index = stk.pop();
                res[index] = nums[i % n];
            }

            stk.push(i % n);
        }
        return res;
    }
}
