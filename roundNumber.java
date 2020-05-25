// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No . Same as first one.


// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] out = new int[nums.length];
        
        int count = 2;
        while(count>0)
        {
            for(int i = nums.length-1; i >=0;i--)
            {
                while(!st.isEmpty() && st.peek()<=nums[i]) st.pop();
                out[i] = st.isEmpty()? -1 : st.peek();
                st.push(nums[i]);
            }
            count--;
        }
        return out;
    }
}