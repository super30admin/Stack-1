// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No . Same as first one.


// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] res = new int[nums.length];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < (nums.length*2);i++)
        {
            int index = i%nums.length;
            while(!st.isEmpty() && nums[st.peek()]<nums[index])
            {
                int popped = st.pop();
                res[popped] = nums[index];
            }
            if(res[index]==-1)
            {
                st.push(index);
            }
        }
        return res;
    }
}