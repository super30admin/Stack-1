// Time Complexity : 0(n)
// Space Complexity : 0(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 0; i < n * 2; i++) {
            while (!s.isEmpty() && nums[i % n] > nums[s.peek()]) {
                int popped = s.pop();
                result[popped] = nums[i % n];
            }
            if (i < n) {
                s.push(i);
            }
        }
        return result;
    }
}