    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/daily-temperatures/
    Time Complexity for operators : O(n) .. n is the length of the array
    Extra Space Complexity for operators : O(n) .. stack
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Start from the first element.
                    B) check while stack is empty or not if not and T[x] > T[stack.peek()] then 
                       ,start while loop abd get the top index, and change the result array[index] with x-index;
                    C) add index to the stack.
                    D) Return result array at the end.
    */ 

class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null)
            return new int[0];
        
        int result[] = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int x = 0; x<T.length;x++){
            while(!stack.isEmpty() && T[x] > T[stack.peek()]){
                int index = stack.pop();
                result[index] = x - index;
            }
            
            stack.push(x);
        }
        
        return result;
    }
}