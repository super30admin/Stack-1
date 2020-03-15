// Time Complexity : O(n) where n is the length of array nums * 2
// Space Complexity : O(n) where n is the length of array nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        if (nums.length == 0) return ans;
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<Integer>();
        int n = nums.length;
        for (int i = 0; i < 2 * nums.length; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                ans[st.pop()] = nums[i % n];
            }
            if (i < n) st.push(i);
        }
        
        return ans;
    }
}