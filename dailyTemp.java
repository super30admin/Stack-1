// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Used concept of monotonic descreasing stack

import java.util.Stack;

class dailyTemp {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stk = new Stack<>();

        stk.push(0);
        for (int i = 1; i < temp.length; i++) {
            while (!stk.isEmpty() && temp[i] > temp[stk.peek()]) {
                temp[stk.peek()] = i - stk.peek();
                stk.pop();
            }
            stk.push(i);
        }
        // Remaining elements in the stack
        while (!stk.isEmpty()) {
            temp[stk.peek()] = 0;
            stk.pop();
        }
        return temp;
    }
}