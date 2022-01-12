// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] result = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        //s.push(temperatures[0]);
        
        for(int i=0;i<temperatures.length;i++) {
            
            while(!s.isEmpty() && temperatures[s.peek()]<temperatures[i]) {
                
                result[s.peek()] = i - s.pop();
            }
            
            s.push(i);
        }
        
        while(!s.isEmpty()) {
            
            result[s.pop()] = 0;
        }
        
        return result;
    }
}