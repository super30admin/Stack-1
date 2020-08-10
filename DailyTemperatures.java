// Time Complexity : O(n) --> where n is the number of elements in the input array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (739): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] T) {
        // edge case
        if (T == null || T.length == 0) return new int[0];
        
        Stack<Integer> st = new Stack<>();
        int result[] = new int[T.length];
        
        for (int i = 0; i < T.length; i++) {
            while(!st.isEmpty() && T[i] > T[st.peek()]) { // if it is able to resolve the top element of the stack
                int index = st.pop();
                result[index] = i - index;
            }
            st.push(i);
        }
        
        return result;
    }
}