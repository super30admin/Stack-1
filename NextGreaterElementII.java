
// Time Complexity : O(2xn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Using stack with the index
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0)
            return new int[0];
        
        int res[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        
        Arrays.fill(res, -1);
        
        for(int i=0; i<nums.length*2; i++){
            int index = i % nums.length;
            
            while(!stack.isEmpty() && nums[index] > nums[stack.peek()]){
                int top = stack.pop();
                res[top] = nums[index];
            }
            
            if(res[index]==-1){
                stack.push(index);
            }
        }
        return res;
    }
}
