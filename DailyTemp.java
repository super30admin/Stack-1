import java.util.Stack;
//TC On SC On

public class DailyTemp {
    public int[] dailyTemperatures(int[] arr) {
        if (arr == null || arr.length == 0)
            return new int[0];
        Stack<Integer> st = new Stack();
        int n = arr.length;
        int[] re = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                int popped = st.pop();
                re[popped] = i-popped ;

            }
            st.push(i);
        }
        return re;
    }
}
