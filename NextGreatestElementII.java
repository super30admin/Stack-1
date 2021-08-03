class Solution {
    public int[] nextGreaterElements(int[] nums) {

        //O(n) space and O(3n) exact time
        int[] result = new int[nums.length];

        if (nums == null) return result;

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        int n = nums.length;

        for (int i=0; i< 2 *n; i++) {

            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                int top = stack.pop();
                result[top] = nums[i%n];
            }
            if (i < n) {
                stack.push(i);
            }

        }

        return result;

    }
}