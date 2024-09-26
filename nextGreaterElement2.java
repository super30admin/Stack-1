/*
Problem: https://leetcode.com/problems/next-greater-element-ii/
TC: O(2 * n)
SC: O(n)
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int result[] = new int[n];
        
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                result[st.pop()] = nums[i];
            }
            st.push(i);
        }
        
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                result[st.pop()] = nums[i];
            }
        }
        
        while (!st.isEmpty()) {
            result[st.pop()] = -1;
        }
        
        return result;
    }
}