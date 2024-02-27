/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(2n)
* 
* Space Complexity: O(n)
* 
*/

import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        // monotonic decreasing stack
        Stack<Integer> st = new Stack<>();

        int n = nums.length;

        int[] result = new int[n];

        st.push(0);

        for (int index = 0; index < n; index++) {
            result[index] = -1;
        }

        for (int index = 1; index < 2 * n; index++) {
            int itemIndex = index % n;

            while (!st.isEmpty() && nums[itemIndex] > nums[st.peek()]) {
                // resolve the lower elements
                result[st.pop()] = nums[itemIndex];
            }

            if (index < n) {
                st.push(index);
            }
        }

        return result;

    }
}
