// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : nopes


class Solution {
    public int[] dailyTemperatures(int[] T) {

        if(T==null || T.length==0)
            return new int[0];

        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack();

        for(int i=0;i<T.length;i++)
        {
            while(!stack.isEmpty() && T[i]>T[stack.peek()])
            {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }
}