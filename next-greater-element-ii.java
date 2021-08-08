// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stk = new Stack();

        for(int i=nums.length*2-1; i>=0; --i){
            while(!stk.isEmpty() && nums[stk.peek()] <= nums[i%nums.length]){
                stk.pop();
            }
            result[i%nums.length] = stk.isEmpty() ? -1: nums[stk.peek()];
            stk.push(i%nums.length);
        }
        return result;
    }
}