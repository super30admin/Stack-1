// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Using Stack
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for(int i=0; i<2*n; i++) {
            int idx = i%n;
            while(!st.isEmpty() && nums[st.peek()] < nums[idx]) {
                int id = st.pop();
                result[id] = nums[idx];
            }
            if(i<n)
                st.push(idx);
        }

        return result;
    }
}