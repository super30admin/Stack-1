// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            result[i] = -1;
        }
        //Go through all the elements
        for(int i=0; i<=(nums.length-1)*2; i++){
            int k = i%nums.length;
            //If stack is empty or the element in stack is greater or equal than the current elemnt, we put current in stack
            if(stk.isEmpty() || nums[stk.peek()] >= nums[k]){
                stk.push(k);
            }
            //If we find the elemnt greater than the element in stack, we calculate the number of days
            else{
                while(!stk.isEmpty() && nums[stk.peek()] < nums[k]){
                    int j = stk.pop();
                    result[j] = nums[k];
                    
                }
                stk.push(k);
            }
        }

        return result;
    }
}