/*
Problem: https://leetcode.com/problems/sum-of-subarray-minimums/
*/
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sumSubarrayMins = 0;
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int n = arr.length;
        
        for (i = 0; i <= n; ++i) {
            while (!st.isEmpty() && arr[st.peek()] > (i == n ? Integer.MIN_VALUE : arr[i])) {
                int j = st.pop();
                int k = st.isEmpty() ? -1 : st.peek();
                sumSubarrayMins = sumSubarrayMins + (long)arr[j] * (j - k) * (i - j);
            }
            st.push(i);
        }
        
        return (int)(sumSubarrayMins % (long)(1e9 + 7));
    }
}