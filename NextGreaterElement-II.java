// Time Complexity : O(n)
// Space Complexity : O(n), stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// go over nums once, maintain a stack to keep track of elements, while iterating array if nums[i]>stack top keep popping elements while condition is true
// if stack still contains elements, now go over the array and pop off elements if nums[i]>stack top, end when stack is empty

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<nums.length; i++){
            
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                result[stack.pop()] = nums[i];
            }
            
            stack.push(i);
        }
        
        if(stack.size()>0){            
            for(int i=0; i<nums.length; i++){
            
                while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                    result[stack.pop()] = nums[i];
                }

                if(stack.isEmpty())
                    break;
            }
        }
        
        return result;
    }
}