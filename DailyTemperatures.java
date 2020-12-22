/**
 * SC : O(n) TC: O(n)
 * Approach : Use stack to keep track of all the previous temps which does not have any warmer temps till current temperature.
 *            if my current temp is warmer than top of stack's temp, pop and put the difference of index. 
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        if(T.length == 0) return res;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < T.length; i++){
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int idx = st.pop();
                res[idx] = i - idx;
            }
            st.push(i);
        }
        return res;
    }
}