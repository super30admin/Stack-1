import java.util.Arrays;
import java.util.Stack;

public class Problem2 {
    //TC : O(n)
    //SC : O(n)
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            while (!s.isEmpty() && nums[i % n] > nums[s.peek()]) {
                int top = s.pop();
                result[top] = nums[i % n];
            }
            s.push(i % n);
        }
        return result;
    }
}
