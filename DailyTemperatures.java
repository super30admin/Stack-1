
// Time Complexity : O(n)
// Space Complexity : O(n) for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length==0) return new int[0];
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<temperatures.length;i++){
            // store all small temperatures in stack and process them when greater temperature comes
            while(!stack.isEmpty()&& temperatures[stack.peek()]<temperatures[i]){
                int popped = stack.pop();
                result[popped]= i-popped;
            }
            stack.push(i);    // push the current temperature
        }
        return result;
    }
}