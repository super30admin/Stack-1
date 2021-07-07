// Time Complexity : O(n), n - > length of current list
// Space Complexity : O(n), stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// We need to check the next higher temperature for a specific day. In the scenario where next higher temperature is not encountered, the index will be populated in the stack.
// Whenever a higher temperature is encountered, the stack will be checked until the current temperature is greater than the top of the stack.

class Solution {
    public int[] dailyTemperatures(int[] T) {
        // edge case
        if(T == null || T.length == 0)
            return new int[]{};
        
        // result array
        int[] result = new int[T.length];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < T.length; i++) {
            while(stack.peek() != null && T[i] > T[stack.peek()]) {
                int top = stack.peek();
                result[top] = i-top;
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
