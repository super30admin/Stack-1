

/**
 * Solves the daily temperatures problem using a monotonic stack.
 * Iterates through temperatures and finds the next warmer day for each index.
 * Returns an array where each entry is the number of days to wait for a warmer temperature.
 */
// Time Complexity: O(N), where N is the number of days
// Space Complexity: O(N), for the stack used to store indices
public class DailyTempreature {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length; 
        int[] result = new int[n]; 
        Stack<Integer> stk = new Stack<>(); 

        for(int i = 0; i < n ; i++) {
            while(!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                int popped = stk.pop();
                result[popped] = i - popped;
            }
            stk.push(i);
        }
            return result;
    }
}
