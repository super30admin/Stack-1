//Time Complexity: O(n)
//Space Complexity: O(n) for Stack

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return null;
        int[] result = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < T.length; i++){
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);
        }
        return result;
    }
}
