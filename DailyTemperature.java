// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int[] res;
    public int[] dailyTemperatures(int[] temperatures) {
        res = new int[temperatures.length];
        
        if(temperatures.length<2)
            return res;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<temperatures.length;i++) {
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]) {
                res[stack.peek()] = i-stack.pop();
            }
            stack.push(i);
        }
        
        return res;
    }
}
