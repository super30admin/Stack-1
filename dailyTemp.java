// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Use a stack to store the indices of the temperatures. The stack will contain the indices of the temperatures in decreasing order (Monotonic stack).
 * 2. Until the current temperature is greater than the peek of the stack, pop the stack and calculate the difference between the current index and the popped index.
 * 3. Store the difference in the result array at the popped index.
 * 4. Push the current index into the stack.
 * 5. Return the result array.
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int popped = stack.pop();
                result[popped] = i - popped;
            }
            stack.push(i);
        }

        return result;
    }
}