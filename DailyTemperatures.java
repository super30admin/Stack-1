/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int[] dailyTemperatures(int[] temperatures) 
    {        
        int length = temperatures.length;
        int result[] = new int[length];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i =1; i < length; i++)
        {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
            {
                int poppedIndex = stack.pop();
                result[poppedIndex] = i - poppedIndex;
            }
            stack.push(i);
        }
        
        return result;
        
    }
}