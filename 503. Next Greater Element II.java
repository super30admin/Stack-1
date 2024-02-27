// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < 2*nums.length; i++){
            int idx = i % nums.length;

            while(!stack.isEmpty() && nums[stack.peek()] < nums[idx]){
                result[stack.pop()] = nums[idx];
            }

            stack.add(idx);
        }

        return result;
    }
}
