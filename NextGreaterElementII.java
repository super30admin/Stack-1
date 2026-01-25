import java.util.Arrays;
import java.util.Stack;

class Solution {
    // Approach: Monotonically increasing stack
    // TC: 2N ~= O(N); N = nums.length
    // SC: O(N) for stack
    public int[] nextGreaterElements(int[] nums) {
        int[] greaterElements = new int[nums.length];
        // Fill with -1 as default
        Arrays.fill(greaterElements, -1);
        Stack<Integer> indexStack = new Stack<>();
        // Iterate 2N times
        for (int i = 0; i < 2 * nums.length; i ++) {
            int element = nums[i % nums.length];
            while (!indexStack.isEmpty() && nums[indexStack.peek()] < element) {
                // greater element found
                int index = indexStack.pop();
                greaterElements[index] = element;
            }
            // push valid index
            if (i < nums.length) {
                indexStack.push(i);
            }
        }
        return greaterElements;
    }
}