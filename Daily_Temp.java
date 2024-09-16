/*
    LeetCode: 739 https://leetcode.com/problems/daily-temperatures/
    Intuition of using stack is: we should some how remember the earlier temperatures 
    Time Complexity: O(N)
    Space Complexity: O(N)
*/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        if(T == null || T.length ==0)
            return new int[]{};
        
        int n = T.length;
        
        int[] result = new int[n];
        
        /* Saving indexes for each day*/
        Stack<Integer> stk = new Stack<>();
        
        /* Keep looking for next warmer day 
            if you find it do -> its index - stk.pop()
            otherwise keeping pushing it on to the stack */
        for(int i=0; i<n; i++)
        {
            while(!stk.isEmpty() && T[i] > T[stk.peek()])
            {
                int index = stk.pop();
                result[index] = i - index;
            }
            
            stk.push(i);
        }
        
        /* At last when you traverse the whole array there might be some unprocessed elements
           which signifies that there is no warmer day ahead for those days 
           so just keep popping the elements from stack and place zero*/
        if(!stk.isEmpty())
        {
            int index = stk.pop();
            result[index] = 0; 
        }
        
        return result;
    }
}
