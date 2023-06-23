// TC - O(n)
// SC - O(n) for stack

/*
 * Approach:
 * We use a monotonic stack to keep pushing unsolved indexes (basically every
 * current element when it doesn't satisfy the condition). As soon as current
 * element solves the top of stack, store in result array and keep doing same
 * thing until stack is empty or until the top is unsolved. At the last
 * element, to solve last element, we visit entire array once again.
 */

import java.util.*;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[] {};
        }

        Stack<Integer> s = new Stack<>(); // monotonic increasing stack
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1); // unsolved initially

        // traverse array twice to accomodate last element
        for(int i = 0; i < n*2; i++) {
            // if current element solves your unsolved elements
            while(!s.isEmpty() && nums[i % n] > nums[s.peek()]) {
                int unsolved = s.pop();
                res[unsolved] = nums[i % n];
            }
            // add current to stack as it's currently unsolved
            if(i < n) {
                // push only once, don't solve them again
                s.push(i);
            }
        }

        return res;
    }
}