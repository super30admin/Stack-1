// TC: O(n)
// SC: O(n)

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return new int[] {};
        }
        int n = temperatures.length;
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int popped = s.pop();
                result[popped] = i - popped;
            }
            s.push(i);
        }
        return result;
    }
}
