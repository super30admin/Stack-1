// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Monotonically increasing stack
// Iterate through array and put index of elements in stack till we reach 
// an index with higher temperature, then we can resolve previous stack elements

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int popped = st.pop();
                res[popped] = i - popped;
            }
            st.push(i);
        }
        return res;
    }
}