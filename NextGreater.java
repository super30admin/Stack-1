import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    // TC : O(n) n - length of nums array
    // SC : O(n)
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[]{};

        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for(int i=0; i < 2 * n; i++) { // since it's a circular array, need to iterate twice
            while(!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) { // after the first pass, value of i will be greater than the array. So, rounding it to the first position
                int top = stack.pop();
                result[top] = nums[i % n];
            }

            if(i < n)
                stack.push(i); // push into the stack only for the first pass
        }
        return result;
    }
}
