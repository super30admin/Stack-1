// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
import java.util.Arrays;
import java.util.Stack;

class DailyTemperatures {
    public int[] dailyTemperature(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, 0);
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        
        DailyTemperatures solution = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperature(temperatures);

        
        System.out.println("Daily Temperatures: " + Arrays.toString(result));
    }
}
