// Time Complexity : O(n), n - > length of current list
// Space Complexity : O(n), stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// We need to find the next greater element wherein rotation is allowed.
// We can get the solution in two passes. In the first pass we need to update the stack and in case we get the next higher element, we need to update result.
// In the second pass, we need to revisit the number array for finding the solution in the case higher element is before a number.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // edge case check
        if(nums == null || nums.length == 0)
            return new int[]{};
        int n = nums.length;
        // result array
        int[] result = new int[n];
        Arrays.fill(result,-1); // default to -1 if no greater element is found
        
        Deque<Integer> stack = new LinkedList<>();
        
        for(int i = 0; i < 2*n; i++) {
            while(!stack.isEmpty() && nums[i%n] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i%n];
            }
            if(i < n)
                stack.push(i);
        }
        return result;
    }
}
