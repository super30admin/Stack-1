// Time Complexity - O(2n) n = no of temp in the array
// Space Complexity - O(n) n = no of temp in the array
// Approach
// Push the temperatures. As soon as a temp is greater than the peek it means a warmer temp is present and it resolves the peek.
// Now check if it also resolves the rest of temp in the stack. If yes, then keep popping till it resolves those temp.
// Store the diff between the peek index and incoming temp index in the res array as the no of days. Return res.

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        if(T == null || T.length == 0) return new int[0];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<T.length;i++) {
            while(!st.isEmpty() && T[i] > T[st.peek()]) {
                int idx = st.pop();
                res[idx] = i-idx;
            }
            st.push(i);
        }
        return res;
    }
}