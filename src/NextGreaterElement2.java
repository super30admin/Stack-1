// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/**
 * https://leetcode.com/problems/next-greater-element-ii/submissions/
 * iterate through array twice, since its circular.
 * use stack to push index of elements in the first pass and if current element is larger than one on the stack
 * pop those from stack and update result array
 * 
 * in second pass, do not push index onto stack, only to check if large number for elements on stack is not found
 * and current number is larger than that of one on the stack, update result
 *
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length];
        
        //init res array with -1 since if no greater element found, we need to set res to -1
        Arrays.fill(res, -1);
        
        Stack<Integer> st = new Stack<>();
        
        //2 iterations of array
        for(int i =0; i< 2*nums.length;i++) {
            
        	    //if we cross limit, recalc the index
            int idx = i >= nums.length ? (i%nums.length) : i;
            
            if(i < nums.length) { //first pass through array, we push index on stack and also do large number check
              
                while(!st.isEmpty() && nums[st.peek()] < nums[idx]) {
                    int temp = st.pop();
                    res[temp] = nums[idx];
                }
                
                st.push(idx);
            } else { //second pass, since its a circular array
            	   // only do large number check for the indices on the stack for which large number is not yet found
                while(!st.isEmpty() && nums[st.peek()] < nums[idx] && res[st.peek()] == -1) {
                    int temp = st.pop();
                    res[temp] = nums[idx];
                }
            }
        }
        
        return res;
    }
}