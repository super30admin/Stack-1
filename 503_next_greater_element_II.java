    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/next-greater-element-ii/
    Time Complexity for operators : O(n*2) .. n is the length of the array
    Extra Space Complexity for operators : O(n)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) First fill the result array with -1 as it will help tp check which element needs to put on the stack.
                    B) Same for loop starting from first element, Also iterate thorugh array twice as it is circular
                       check while stack is not qmpty and nums[i] > nums[stack.peek(), Get the index and store result[index] = nums[i]
                    C) If result[i] == -1 that means it is not processed then only add it to  the stack.
                    D) At the end, return result.
    */ 

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        if(nums == null)
            return new int[0];
        
        int result[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        
        Arrays.fill(result, -1);
        for(int x = 0; x<nums.length*2;x++){
            int i = x%nums.length;
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                int index = stack.pop();
                result[index] = nums[i];
            }
            
            if(result[i] == -1)
                stack.push(i);
        }
        
        return result;
    }
}