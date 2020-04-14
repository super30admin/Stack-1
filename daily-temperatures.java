// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int index=0;index<T.length;index++)
        {
            while(!stack.isEmpty() && T[index]>T[stack.peek()])
            {
                int priorIndex=stack.pop();
                result[priorIndex]=index-priorIndex;
            }
            stack.push(index);
        }
        return result;
    }
}
