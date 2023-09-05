// Time Complexity : O(4n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Create a monotonic stack to store the indices of the elements.
 * 2. Until the current element is greater than the peek of the stack, pop the stack and store the current element at the popped index in the result array.
 * 3. Push the current index into the stack.
 * 4. Repeat the above steps for the second iteration of the array.
 * 5. Return the result array.
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<2*n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]){
                int popped = stack.pop();
                result[popped] = nums[i%n];
            }
            stack.push(i%n);
        }

        return result;
    }
}