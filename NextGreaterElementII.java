import java.util.Stack;
import java.util.*;

// Time Complexity: O(n) where n is the length of the input array.
// Space Complexity: O(n) for the stack used to store indices of elements.
// Intuition: The problem is to find the next greater element for each element in a circular array.
// We can achieve this by using a stack to keep track of indices of elements.
// We iterate through the array twice (to handle the circular nature) and for each element,
// we check if the current element is greater than the element at the index stored at the top of the stack.

class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack();
        Arrays.fill(result, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int poppedIdx = st.pop();
                result[poppedIdx] = nums[i % n];
            }
            if (i < n) {
                st.push(i);
            }
        }

        return result;
    }
}