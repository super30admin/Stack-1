import java.util.Stack;
/*
Daily Temperatures
approach: keep track of elements for which we didn't see a high temperature in a stack
time: O(n + n) one n is for running on elements, another for pushing and popping
space: O(n)
 */
public class Problem1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int m = temperatures.length;
        int[] res = new int[m];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<m;i++) {
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]) {
                int pop = st.pop();
                res[pop] = i-pop;
            }
            st.push(i);
        }


        return res;
    }
}
