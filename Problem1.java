import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem1 {
    //Solution with Stack
    // TC : O (n)
    // SC : O (n)
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[]{};

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                int index = s.pop();
                result[index] = i - index;
            }
            s.push(i);
        }

        return result;
    }
}
