// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach:  Used a monotonic stack to store values until found a number greater than the current one. Then added that number in the result. The iteration on the array was done 2 times in order to get all the answers

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        int n = nums.length;

        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < 2 * nums.length; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int index = st.pop();
                result[index] = nums[i % n];
            }

            if (i < n)
                st.push(i % n);
        }

        return result;

    }
}