// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                
               result[stack.peek()] = i - stack.peek();
               stack.pop(); 
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            result[stack.peek()] = 0;
            stack.pop();
        }
        
        return result;
    }
}