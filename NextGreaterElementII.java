// Time Complexity : O(n) n - nums; max 2n traversal if the greatest elem is at the last.
// Space Complexity : O(n) n - nums; stack size will be n; if all in decreasing no greater elem is present
// Did this code successfully run on Leetcode : Yes;(https://leetcode.com/submissions/detail/679845861/)
// Any problem you faced while coding this : No;
// My Notes : IF elem greater than found; then update the previous one and push the curr one till the top is greater or all decreasing elems
// Remaining elems; iterate and search again.
// Notes : try reverse approach also
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<int[]> stack = new Stack<>();
        
        // Iterate the nums array and check if greater elem found
        for(int i=0;i<nums.length;i++){
            // If greater elem found; then pop and update after what index position it is found
            while(!stack.isEmpty() && nums[i] > stack.peek()[1]){
                    int[] prevElem = stack.pop();
                    result[prevElem[0]] = nums[i];
            }
            stack.push(new int[]{i,nums[i]});
        }
        
        // remaining elems in stack are ones which are not found; for them reiterate till the curr Index of elem in stack
        while(!stack.isEmpty()){
            int[] currElem = stack.pop();
                //System.out.println(" Checking for : "+currElem[1]);
            boolean isFound = false;
            // Iterate till the curr Elem index
            for(int i=0;i<currElem[0];i++){
                if(nums[i] > currElem[1]){
                    result[currElem[0]] = nums[i];
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                result[currElem[0]] = -1;
            }
        }
        return result;
    }
}