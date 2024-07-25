import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Tc: O(n) Sc: O(n)
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n];
        for (int currDay = 0; currDay < n; currDay++) {
            int currTemp = temperatures[currDay];
            while (!st.isEmpty() && temperatures[st.peek()] < currTemp) {
                int prevDay = st.pop();
                res[prevDay] = currDay - prevDay;
            }

            st.push(currDay);
        }
        return res;
    }
}