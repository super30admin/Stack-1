class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = 2 * nums.length - 1;
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int index = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                int pop = stack.pop();
                result[pop] = nums[index];
            }
            stack.push(index);
        }
        return result;
    }
}