/*
    LC - 503. Next Greater Element II
    TC - O(n)
    SC - O(n)
    Approach -
        Using stack
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[]{};
        }
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for(int i=0; i < 2 * n; i++) {
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int popped = st.pop();
                result[popped] = nums[i % n];
            }
            if(!st.isEmpty() && i % n == st.peek()) {
                break;
            }
            if(i < n) {
                st.push(i);
            }
        }
        return result;
    }
}