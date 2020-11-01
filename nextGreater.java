//Time:O(N)
//Space:O(N)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        int n = nums.length;
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {

            while (!st.isEmpty() && nums[st.peek()] < nums[i % n]) {

                res[st.pop()] = nums[i % n];
            }
            st.push(i % n);
        }

        return res;
    }
}