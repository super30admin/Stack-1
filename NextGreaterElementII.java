// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: 
// The nextGreaterElements function finds the next greater element for each element in an array using a circular approach. It iterates through the array twice, maintaining a stack of indices to track potential greater elements. During each iteration, it updates a result array with the next greater values. This algorithm ensures linear time complexity O(n) and linear space complexity O(n), providing efficient element comparison and storage.

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int popped = st.pop();
                result[popped] = nums[i % n];
            }
            if (i < n) {
                st.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementII obj = new NextGreaterElementII();

        // Test case 1
        int[] nums1 = { 1, 2, 1 };
        int[] result1 = obj.nextGreaterElements(nums1);
        System.out.println(Arrays.toString(result1)); // Output: [2, -1, 2]

        // Test case 2
        int[] nums2 = { 5, 4, 3, 2, 1 };
        int[] result2 = obj.nextGreaterElements(nums2);
        System.out.println(Arrays.toString(result2)); // Output: [-1, 5, 5, 5, 5]

        // Test case 3
        int[] nums3 = { 3, 8, 4, 1, 2 };
        int[] result3 = obj.nextGreaterElements(nums3);
        System.out.println(Arrays.toString(result3)); // Output: [8, -1, 8, 2, 3]
    }
}
