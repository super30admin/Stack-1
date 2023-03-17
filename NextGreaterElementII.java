// TC: O(n)
// SC: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[] {};
        }
        Stack<Integer> s = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for(int i = 2 * nums.length - 1; i >= 0; i--) {
            while(!s.isEmpty() && nums[s.peek()] <= nums[i % nums.length]) {
                s.pop();
            }
            if(!s.isEmpty()) {
                result[i % nums.length] = nums[s.peek()];
            }
            s.push(i % nums.length);
        }
        return result;
    }
}