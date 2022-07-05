// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// we'll add elements index in stack and check if next ele is greater, if yes, will add in result, at max
//we'll traverse twice over input
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < 2 * n; i++) {

            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                result[st.peek()] = nums[i % n];
                st.pop();
            }
            if (i < n) {
                st.push(i);
                result[i % n] = -1;
            }

        }
        return result;
    }
}