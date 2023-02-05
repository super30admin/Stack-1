// Time Complexity : O(3n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
 * maintain a stack to store the indexes of the nums one by one.
 * if we find a greater number, find the idff between the next index and top index in stack
 *  we run the loop 2 times since we can go circular to find next greater number, so index is created by % n.
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        if (nums.length == 0 || nums == null)
            return result;

        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            while (!st.isEmpty() && nums[idx] > nums[st.peek()]) {
                int popIdx = st.pop();
                result[popIdx] = nums[idx];
            }

            if (i < n) {
                st.push(i);
            }
        }

        return result;

    }
}