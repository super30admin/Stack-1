/*
Problem: https://leetcode.com/problems/daily-temperatures/
*/
// TC: O(n)
// SC: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int n = temperatures.length;
        int result[] = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                result[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        
        while (!st.isEmpty()) {
            result[st.pop()] = 0;
        }
        
        return result;
    }
}