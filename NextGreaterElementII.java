// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] result = new int[nums.length];

        if(nums == null || nums.length == 0)
            return result;

        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < 2 * nums.length; i++){
            int idx = i % nums.length;
            while(!st.isEmpty() && nums[st.peek()] < nums[idx]){
                int popIndex = st.pop();
                result[popIndex] = nums[idx];
            }
            if(i < nums.length)
                st.push(i);
        }
        return result;
    }
}