/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity- O(N)
Space Complexity- O(N)
*/
import java.util.Stack;

public class DailyTemperatures_LC_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[temperatures.length];
        int count = 0;
        for(int i = 0; i<temperatures.length; i++) {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int poppedIndex = st.pop();
                answer[poppedIndex] = i -  poppedIndex;

            }
            st.push(i);
        }
        return answer;
    }
}


