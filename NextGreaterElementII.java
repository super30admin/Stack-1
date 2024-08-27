// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class NextGreaterElementII {
    // Using Monotnoic stack
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // O(n)

        for (int i = 0; i < 2 * n; i++) { //for circular array
            int idx = i % n;
            while (!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                int popped = stack.pop();
                result[popped] = nums[idx];
            }
            if (i < n) {
                stack.push(idx);
            }
        }
        return result;
    }
}