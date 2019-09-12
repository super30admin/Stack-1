import java.util.Stack;

/*Time Complexity: O(N), where N is the length of T and WW is the number of allowed values for T[i]. Each index gets pushed and popped at most once from the stack.

Space Complexity: O(W). The size of the stack is bounded as it represents strictly increasing temperatures.*/

public class DailyTemperatures {
	    public int[] dailyTemperatures(int[] T) {
	        int[] ans = new int[T.length];
	        Stack<Integer> stack = new Stack();
	        for (int i = T.length - 1; i >= 0; --i) {
	            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
	            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
	            stack.push(i);
	        }
	        return ans;
	    }
}
