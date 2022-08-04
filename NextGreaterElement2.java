// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int[] res;
    public int[] nextGreaterElements(int[] nums) {
        res = new int[nums.length];
        
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res,-1);
        for(int i=0;i<2*nums.length;i++) {
            while(!stack.isEmpty() && nums[i % nums.length]>nums[stack.peek()]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            if(i<nums.length)
                stack.push(i);
        }
        
        return res;
    }
}
