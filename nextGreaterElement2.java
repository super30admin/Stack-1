// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack();
        int[] result = new int[nums.length];
        int n = nums.length;
        
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.peek()] = nums[i % n];
                stack.pop();
            }
            
            if (i < n) {
                stack.push(i);
            }
        }
        
        while (!stack.isEmpty()) {
            result[stack.peek()] = -1;
            stack.pop();
        }
        
        return result;
    }
}