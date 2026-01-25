import java.util.Stack;

// Approach: Monotonically increasing stack
// TC: O(N); N = temperatures.length
// SC: O(N) for stack
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] daysToWarmerDay = new int[temperatures.length];
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < temperatures.length; i ++) {
            while (!indexStack.isEmpty() && temperatures[i] > temperatures[indexStack.peek()]) {
                // warmer day found
                int poppedIndex = indexStack.pop();
                daysToWarmerDay[poppedIndex] = i - poppedIndex;
            }
            // push index
            indexStack.push(i);
        }
        return daysToWarmerDay;
    }
}