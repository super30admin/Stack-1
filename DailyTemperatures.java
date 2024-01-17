import java.util.Stack;

public class DailyTemperatures {
    //Brute Force
    public int[] dailyTemperatures(int[] temperatures) {
//        TC:O(n^2)
        int count = 0;
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            for(int  j = i; j < n ; j++){
                if(temperatures[j] > temperatures[i]){
                    ans[i] = j-i;
                    break;
                }
            }

        }
        return ans;

    }

    public int[] dailyTemperatures2(int[] temperatures) {
//        TC:O(2n) Monotonically decreasing stack
//        SC:O(n)
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }
}
