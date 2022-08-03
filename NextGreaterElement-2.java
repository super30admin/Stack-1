// Time Complexity : O(3N) = O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        // This is Mnontonic Stack problem
        // Since the list is circular we need to use % and move 2 times throught the array
        // to complete the circle
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            int index = i % n;

            while (!st.isEmpty() && nums[index] > nums[st.peek()]) {

                // nums[index] is the ans
                ans[st.pop()] = nums[index];
            }

            if (i < n) {
                st.push(i);
            }

        }

        return ans;

    }
}