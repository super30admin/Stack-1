/*
Problem: https://leetcode.com/problems/sum-of-subarray-ranges/
*/
class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int j, k;
        long res = 0; 
        
        // Step 1: find the number of subarrays each number is a maximum for
        for (int i = 0; i <= n; ++i) {
            while (!st.isEmpty() && nums[st.peek()] < (i == n ? Long.MAX_VALUE : nums[i])) {
                j = st.pop();
                k = st.isEmpty() ? -1 : st.peek();
                // Since nums is int, we want to type cast it to long
                res = (long) res + (long) nums[j] * (j-k) * (i-j);
            }
            st.push(i);
        }
        
        st.clear();
        
        // Step 2: find the number of subarrays each number is a minimum for
        for (int i = 0; i <= n; ++i) {
            while (!st.isEmpty() && nums[st.peek()] > (i == n ? Long.MIN_VALUE : nums[i])) {
                j = st.pop();
                k = st.isEmpty() ? -1 : st.peek();
                // Since nums is int, we want to type cast it to long
                res = res - (long) nums[j] * (j-k) * (i-j);
            }
            st.push(i);
        }
        
        return res;
    }
}