// TC - O(n)
// SC - O(n) for stack

/*
 * Approach
 * We use a monotonic increasing stack in order to keep track of all the
 * unsolved elements until we find the solution. Once we find the solution at
 * any point, we keep solving all the elements in the stack one by one for any
 * matching condition. Once we stop at an unsolvable element, we proceed
 * forward.
 */

import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }

        int n = temperatures.length;
        int[] res = new int[n];
        // monotonic stack, contains indices of unsolved elements
        Stack<Integer> s = new Stack<>(); 
        s.push(0); // first element is always unsolved initially

        for(int i=1; i<n; i++) {
            // check condition and solve all unsolved elements 
            // that satisfy the condition
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int unsolved = s.pop();
                res[unsolved] = i-unsolved;
            }
            // once we find something unsolvable (for now), push onto stack
            s.push(i);
        }

        return res;
    }
}
