// Time complexity: O(N)
// Space complexity: O(N)
import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < T.length; i++)
        {
            while(!st.isEmpty() && T[i] > T[st.peek()])
            {
                int idx = st.pop();
                res[idx] = i - idx;
            }
            st.push(i); 
        }
        return res;
        
    }
}