//time complexity  - O(n)
//space complexity - O(n)
import java.util.*;
public class DailyTemperatures {
    static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stk.isEmpty() && temperatures[stk.peek()]< temperatures[i]) {
                int ind = stk.pop();
                res[ind] = i - ind;
            }
            stk.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println("Temperatures: "+ Arrays.toString(temperatures));
        System.out.println("Warmer temperaturesL: " + Arrays.toString(dailyTemperatures(temperatures)));
    }
}
