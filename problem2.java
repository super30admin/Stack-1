import java.util.Stack;
// Time Complexity: O(2*n)
// Space Complexity: O(n)
public class problem2 {
    public int[] nextGreaterElements(int[] num) {
        int n = num.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2*n; i++) {
            while (!stack.isEmpty() && num[stack.peek()] < num[i%n]) {
                int e=stack.pop();
                res[e] = num[i%n];
            }
            if(i<n)
            {
                stack.push(i%n);
            }
        }
        return res;
    }
}
