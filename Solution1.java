//Time complexity: O(n), where n is the length of temperatures.
//Space complexity: O(n)

import java.util.*;

class Solution1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] output = new int[n];
        Stack<Integer> stack = new Stack<>(); 
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();  
            }
            if(stack.isEmpty()) output[i] = 0;
            else output[i] = stack.peek() - i;
            stack.push(i);
            
        }
                
        return output;
    }
}