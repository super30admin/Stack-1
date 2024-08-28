//Time Complexity = O(N)
//Space Complexity = O(N)

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> st = new Stack<>();

        int n = temperatures.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int popped = st.pop();
                answer[popped] = i - popped;
            }
            st.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        
        DailyTemperatures solution = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);

    
        System.out.println("Daily Temperatures Result: " + java.util.Arrays.toString(result));
    }
}
