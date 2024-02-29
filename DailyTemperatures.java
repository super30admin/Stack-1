import java.util.Stack;

public class DailyTemperatures {
    // TC: O(N) where N is length of temperatures
    // SC: O(N) where N is length of temperatures
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> decStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!decStack.isEmpty() && temperatures[decStack.peek()] < temperatures[i]) {
                int index = decStack.pop();
                result[index] = i - index;
            }
            decStack.push(i);
        }
        return result;
    }
}
