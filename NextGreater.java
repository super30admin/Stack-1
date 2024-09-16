// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[]{};
        int n = nums.length;
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<>();
        for(int index = 0;index<2*n;index++){
            while(!stack.isEmpty() && nums[index%n]>nums[stack.peek()]){
                int priorIndex = stack.pop();
                result[priorIndex] = nums[index%n];
            }
            if(index<n)stack.push(index%n);
        }
        return result;
    }
}