import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    // TC: O(N) where N is length of temperatures
    // SC: O(N) where N is length of temperatures
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> decStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!decStack.isEmpty() && nums[decStack.peek()] < nums[i]) {
                int index = decStack.pop();
                result[index] = nums[i];
            }
            decStack.push(i);
        }
        for (int i = 0; i < n; i++) {
            while (!decStack.isEmpty() && nums[decStack.peek()] < nums[i]) {
                int index = decStack.pop();
                result[index] = nums[i];
            }
        }
        return result;
    }
}
