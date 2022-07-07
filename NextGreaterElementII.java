// Time Complexity : O(3N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        // we do two rounds of traversal
        // in first cycle, we will push the values to the stack
        // in second, we will unfold all the resolved value from stack
        for(int i=0;i<2*n;i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]) {
                res[st.pop()] = nums[i%n];
            }
            if(i<n) st.push(i);
            if(i>=n && !st.isEmpty() && st.peek() == i%n) break;
        }
        return res;
    }
}