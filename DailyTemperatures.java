/**
Time Complexity : O(1)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class Solution 
{
    public int[] dailyTemperatures(int[] T) 
    {
        if(T == null || T.length == 0)
            return T;
        
        int result[] = new int[T.length];
        
        Arrays.fill(result, 0);
        
        Stack<Integer> stack = new Stack<>();
        
        for( int i =0 ;i < T.length; i++)
        {
            
            int current = T[i];
            
            while( !stack.isEmpty() && current > T[stack.peek()])
            {
                int stackTop = stack.pop();
                result[stackTop] = i - stackTop;
            }
            stack.push(i);
        }
        return result;
        
    }
}