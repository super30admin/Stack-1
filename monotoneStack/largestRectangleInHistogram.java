/*
Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/
*/

// Approach 1: Brute force: TC: O(n ^ 2) -> TLE
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        
        int maxArea = 0;
        
        for (int i = 0;  i < heights.length; ++i) {
            int min = heights[i];
            for (int j = i; j < heights.length; ++j) {
                min = Math.min(min, heights[j]);
                maxArea = Math.max(maxArea, min * (j - i + 1));
            }
        }
        
        return maxArea;
    }
}

// Approach 2: Stack: TC: O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        
        for (int i = 0; i <= n; ++i) {
            while (!st.isEmpty() && (heights[st.peek()] > (i == n ? Integer.MIN_VALUE : heights[i]))) {
                int j = st.pop();
                int k = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[j] * (i - k - 1));
            }
            st.push(i);
        }
        
        return maxArea;
    }
}