class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        Stack<Integer> stack = new Stack<>();

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i = 0; i < (n*2); ++i) {
            while(!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                int popped = stack.pop();
                result[popped] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
        
    }
}