// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        for(int i = 0; i < 2 * n; i++) {
            while(!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                int top = stack.pop();
                result[top] = nums[i % n];
            }
            
            stack.push(i % n);
        }
        
        return result;
    }
}