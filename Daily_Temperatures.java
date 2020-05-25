// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        result[T.length-1] = 0;
        stack.push(T.length-1);
        for(int i = T.length-2; i >= 0; i--)
        {
            int curr = T[i];
            while(!stack.isEmpty()  && T[stack.peek()] <= curr){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i] = 0;
            }
            else{
             result[i] = stack.peek() - i;                
            }
            stack.push(i);
        }
        return result;       
    }
}