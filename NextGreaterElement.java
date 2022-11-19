// Time Complexity:  O(N)
// Space Complexity : O(N), N-> worst case is length of input array
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[] {};

        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 0; i < n * 2; i ++) {
            while (!s.isEmpty() && nums[i % n] > nums[s.peek()]) {
                result[s.pop()] = nums[i % n];
            }
            if (i < n) {
                s.push(i);
            }
        }

        return result;
    }
}
