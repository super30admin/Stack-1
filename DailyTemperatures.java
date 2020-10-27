
// Time Complexity : O(n+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
// Using stack with element and index
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T==null || T.length==0)
            return new int[0];
        
        int[] res = new int[T.length];

        Stack<Integer> stack = new Stack();
        
        for (int i = 0 ; i < T.length; i++){
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int top = stack.pop();
                res[top] = i - top;
            }
            stack.push(i);
        }
        return res;
    }
}