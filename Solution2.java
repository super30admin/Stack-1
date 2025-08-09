// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
class Solution2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stk = new ArrayDeque<>();

        for (int i = 0; i < 2*n; i++) {
            int curr = nums[i%n];

            while (!stk.isEmpty() && nums[stk.peek()] < curr) {
                result[stk.pop()] = curr;
            }

            if (i < n) stk.push(i);
        }

        return result;
    }
}