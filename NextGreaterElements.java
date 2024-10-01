// Problem 503. Next Greater Element II
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 2 * n; i++){
            int num = nums[i % n]; // Use modulo to wrap around
            while(!stack.isEmpty() && nums[stack.peek()] < num){
                result[stack.pop()] = num;
            }
            if(i < n){
                stack.push(i);
            }
        }
        return result;
    }
}
