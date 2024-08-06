/*
    LC - 739. Daily Temperatures
    TC - O(n)
    SC - O(n)
    Approach -
        // monotonic increasing stack 
        in this problem we can notice, that index is increasing in the stack.

        check if stack is empty or not
        if it is not empty and temperature of curr > temp of peeked
            then pop and add the diff (i - popped) to respective popped(index) to result
        
        push the index;

        TC - O(n + n) ~ O(n)
        SC - O(n)
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;
    }
}