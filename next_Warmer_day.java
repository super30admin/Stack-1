// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0)
            return T;
        
        int[] output = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        
        
        for(int i = 0; i< T.length; i++){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                int index = stack.pop();
                output[index] = i - index; 
            }
            stack.push(i);
        }

        return output;
    }
}