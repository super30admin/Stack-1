// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
    
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[nums.length];
        Arrays.fill(output,-1);
        
        for(int i = 0; i< 2 * nums.length; i++){
            int mod = i % nums.length;
            while(!stack.isEmpty() && nums[mod] > nums[stack.peek()]){
                int index = stack.pop();
                output[index] = nums[mod];
            }
            if(i < nums.length)
                stack.push(mod);
        }
        return(output);
    }
    
}