/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int len = nums.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i = 2*len-1; i>=0 ; i--){

            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i%len])
                stack.pop();

            result[i%len] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i%len);
        }
        return result;
    }
}