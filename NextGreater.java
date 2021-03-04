/**
Time Complexity : O(1)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class Solution 
{
    public int[] nextGreaterElements(int[] nums) 
    {
        if( nums == null || nums.length ==0)
            return nums;
        
        int result[] = new int[nums.length];
        Arrays.fill(result, -1);
        
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        
        
        for( int i =0 ;i < 2 * length ; i++)
        {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%length])
            {
                int index = stack.pop();
                result[index] = nums[i%length];
            }
            
            if( i < length)
            {
                stack.push(i);
            }
        }
        
        
        return result;
    }
}