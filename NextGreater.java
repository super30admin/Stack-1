/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int[] nextGreaterElements(int[] nums) 
    {
        
        int length = nums.length;
        
        int result[] = new int[length];
        Arrays.fill(result, -1);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < 2*length; i++)
        {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%length])
            {
                int poppedIndex = stack.pop();
                result[poppedIndex] = nums[i%length];
            }
            
            if(i < length)
                stack.push(i);
        }
        
        return result;
        
    }
}