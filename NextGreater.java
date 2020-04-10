// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
    //base
        if(nums==null || nums.length ==0) return new int[0];
        Stack<Integer> stack =  new Stack<>();
        int n =nums.length;
        for(int i = n-1; i>=0;i--){
            stack.push(i);
        }
        int[] result = new int[n];
        for(int i =n-1;i>=0;i--){
            result[i]=-1;
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i] = nums[stack.peek()];
            }
            stack.add(i);
        }
        return result;
    }

}