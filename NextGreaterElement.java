import java.util.Arrays;
import java.util.Stack;

/*
Time Complexity : O(3N)
Space Complexity : O(N) in stack
Approach :
Lets solve it in 2 pass.
Go through the array element
1. if the new value is larger than the peek, pop the smaller value. Store this new value in the result.
2. Add the value to stack, there might be some value larger than this in the input.

Now, in the stack we have all values in increasing  order (from top to bottom). So for these values
we need to find larger values in the inout array.
Go through the array elements again,
1. If the current value is greater than stack peek, store it as result, as we found the next larger element of stack peek.
2. Pop from stack and compare
 */

public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int poppedIndex = stack.pop();
                result[poppedIndex] = nums[i];
            }
            stack.push(i);
        }

        for (int num : nums) {
            while (nums[stack.peek()] < num) {
                int poppedIndex = stack.pop();
                result[poppedIndex] = num;
            }
        }

        return result;
    }
}
