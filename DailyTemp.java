package Stack1;
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
import java.util.Stack;

public class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()] ){
                int top = st.pop();
                result[top] = i - top;
            }
            st.push(i);
        }
        return result;
    }
}
