import java.util.Stack;

public class Temperature {
    // TC O(2N)
    // SC O(N)
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }

        Stack<Integer> s = new Stack<>();
        s.push(0);
        int[] res = new int[T.length];
        for (int i = 1; i < T.length; i++) {
            while (!s.isEmpty() && T[i] > T[s.peek()]) {
                res[s.peek()] = i - s.peek();
                s.pop();
            }
            s.push(i);
        }
        return res;
    }
}
